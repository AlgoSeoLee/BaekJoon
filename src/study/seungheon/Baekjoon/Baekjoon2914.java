package baekjoon;

import java.util.Scanner;

public class Baek2914 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		int numOne = scn.nextInt();
		int numTwo = scn.nextInt();
		
		System.out.println(numOne*(numTwo-1) +1);
	}
}
