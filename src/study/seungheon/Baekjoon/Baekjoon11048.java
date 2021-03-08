package algorithm;

import java.util.Scanner;

public class Baekjoon11048 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		int N = scn.nextInt();
		int M = scn.nextInt();
		
		int [][] numArray = new int[N+1][M+1];
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				numArray[i][j] = scn.nextInt();
			}
		}
		
		int countNumArray[][] = new int[N+1][M+1];
		
		for (int i = 1; i <= N; i++) {
			for (int j =1; j <= M; j++) {
				countNumArray[i][j] += Math.max(countNumArray[i-1][j], countNumArray[i][j-1]) + numArray[i][j];
			}
		}
		
		System.out.println(countNumArray[N][M]);
	}
}
