package baekjoon;

import java.util.Scanner;

public class Baekjoon8370 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		int n1 = scn.nextInt();
		int k1 = scn.nextInt();
		int n2 = scn.nextInt();
		int k2 = scn.nextInt();
		
		System.out.println(n1*k1 + n2*k2);
	}
}