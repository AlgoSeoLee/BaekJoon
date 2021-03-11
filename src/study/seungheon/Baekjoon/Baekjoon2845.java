package baekjoon;

import java.util.Scanner;

class Baek2845 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int people = scn.nextInt();
		int size = scn.nextInt();

		int expect[] = new int[5];

		for (int i = 0; i < expect.length; i++) {
			int number = scn.nextInt();
			expect[i] = number;
		}

		for (int sub : expect) {
			System.out.print(sub - (people*size) + " ");
		}
	}
}
