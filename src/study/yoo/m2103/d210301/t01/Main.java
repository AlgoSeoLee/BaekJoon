package study.yoo.m2103.d210301.t01;

import java.util.Scanner;

//파도반 수열 9461
//https://www.acmicpc.net/problem/9461
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int triangle = sc.nextInt(), n;
		
		for(int i = 0; i < triangle; i++) {
			n = sc.nextInt();
			long[] dp = new long[n+1];
			dp[1] = 1;
			
			if(n >= 2) dp[2] = 1;
			
			for(int j = 3; j < n+1; j++)
				dp[j] = dp[j-2] + dp[j-3];
			
			System.out.println(dp[n]);
		}
	}
}