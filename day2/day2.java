package adventofcode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;


public class day2  {

	public static void main(String[] args) throws IOException {
		 System.out.println(part1());
		System.out.println(part2());
	}
	
	public static int part1() throws IOException {
		return execute(12, 2);
	}
	
	public  static int part2() throws IOException {
		return bruteForceFindingNumber(3790645, 99);
	}

	private static int bruteForceFindingNumber(int number, int bound) throws IOException {
		for(int i = 0; i<bound;i++) {
			for(int j = 0; j<bound; j++) {
					if(execute(i, j) == number) {
						return 100 * i + j;
					}
				}
		}
		return -1;
	}

	private static int execute(int x, int y) throws IOException {
		
		File file = new File("/home/girusta/Downloads/inputday2.txt");

		BufferedReader br = new BufferedReader(new FileReader(file));
		int[] program = Arrays.stream(br.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
		program[1] = x;
		program[2] = y;
		for(int i = 0; executeInstruction(program, i, program[i]); i+=4);
		return program[0];
	}

	private static boolean executeInstruction(int[] program, int i, int instruction) {
		switch(instruction) {
			case 1: program[program[i+3]] = program[program[i+1]] + program[program[i+2]]; break;
			case 2: program[program[i+3]] = program[program[i+1]] * program[program[i+2]]; break;
			case 99: return false;
			default: throw new IllegalStateException("Something went wrong!");
		}
		
		return true;
	}

}