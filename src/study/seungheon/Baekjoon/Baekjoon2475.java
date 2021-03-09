package baekjoon;

import java.util.Scanner;

public class Baek2475 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		int numArray[] = new int[5];
		
		for (int i = 0; i < numArray.length; i ++) {
			int number = scn.nextInt();
			int pow = (int)Math.pow(number, 2);
			numArray[i] = pow;
		}
		
		int result = 0;
		
		for (int number : numArray) {
			result += number;
		}
		
		System.out.println(result%10);
	}
}
