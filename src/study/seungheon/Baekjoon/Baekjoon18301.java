package baekjoon;

import java.util.Scanner;

public class Baekjoon18301 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		int n1 = scn.nextInt();
		int n2 = scn.nextInt();
		int n3 = scn.nextInt();
		
		System.out.println((n1+1)*(n2+1)/(n3+1)-1);
	}
}