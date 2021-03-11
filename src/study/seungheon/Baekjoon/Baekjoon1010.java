package baekjoon;

import java.util.Scanner;

public class Baekjoon1010 {
	
	public static int combination(int n, int r) {
		if (n == r || r == 0) {
			return 1;
		} else {
			return combination(n-1, r-1) + combination(n-1, r);
		}
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		int testCase = scn.nextInt();
		
		for (int i = 0; i < testCase; i++) {
			int N = scn.nextInt();
			int M = scn.nextInt();
			
			System.out.println(combination(M, N));
		}
	}
}