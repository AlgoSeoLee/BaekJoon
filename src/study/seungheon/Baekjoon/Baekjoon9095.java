package algorithm;

import java.util.Scanner;

public class Baekjoon9095 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		int count = scn.nextInt();
		
		int[] array = new int[11];
		
		array[0] = 0;
		array[1] = 1;
		array[2] = 2;
		array[3] = 4;
		
		for (int i = 0; i < count; i++) {
			int number = scn.nextInt();
			for (int j = 4; j <= number; j++) {
				array[j] = array[j-1] + array[j-2] + array[j-3];
			}
			System.out.println(array[number]);
		}
	}

}
