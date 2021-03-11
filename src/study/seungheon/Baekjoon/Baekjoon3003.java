package baekjoon;

import java.util.Scanner;

class Baek3003 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int chess[] = {1, 1, 2, 2, 2, 8};
		int numArray[] = new int[6];

		for (int i = 0; i < numArray.length; i++) {
			int number = scn.nextInt();
			numArray[i] = number;
		}

		for (int i = 0; i < numArray.length; i++) {
			System.out.print(chess[i] - numArray[i] + " ");
		}
	}
}
