package baekjoon;

import java.util.Scanner;

public class Baekjoon5522 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		int numArray[] = new int[5];
		int sum = 0;
		
		for (int i = 0; i < numArray.length; i++) {
			int number = scn.nextInt();
			numArray[i] = number;
			sum += numArray[i];
		}
		
		System.out.println(sum);
	}
}
