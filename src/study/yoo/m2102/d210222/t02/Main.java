package study.yoo.m2102.d210222.t02;

import java.util.Scanner;

// 동전0
public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();

		int[] coin = new int[N];

		for (int i = 0; i < N; i++) {
			coin[i] = sc.nextInt();
		}

		int count = 0;

		for (int i = N - 1; i >= 0; i--) { 
			//현재 동전 보다 작을때 구성가능
			if (coin[i] <= K) {
				count += (K / coin[i]);
				K = K % coin[i];
			}
		}
		System.out.println(count);
	}
}