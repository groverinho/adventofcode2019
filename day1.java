/**
 * 
 */
package adventofcode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author girusta
 *
 */
public class day1 {

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	
	public static int fuelForMass(int m) {
		return (int) (m / 3 - 2);
	}
	
	public static int adjuts(int fuel) {
		int fuelForFuel = fuelForMass(fuel);
		if (fuelForFuel<=0) {
			return fuel;
		} else {
			return fuel + adjuts(fuelForFuel);
		}
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner in = new Scanner(System.in);
		File file = new File("/home/girusta/Downloads/inputday1.txt");

		BufferedReader br = new BufferedReader(new FileReader(file));

		String st;
		int sum = 0;
		while ((st = br.readLine()) != null) {
			int m = Integer.parseInt(st);
			int subTotal = adjuts(fuelForMass(m));
			sum += subTotal;

		}
		System.out.println(sum);

	}

}
