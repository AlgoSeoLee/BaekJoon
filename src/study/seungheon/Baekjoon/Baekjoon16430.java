package baekjoon;

import java.util.Scanner;

public class Baekjoon16430 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		int A = scn.nextInt();
		int B = scn.nextInt();
		
		int C  = B-A;
		int D = B;
		
		System.out.println(C + " " + D);
	}
}