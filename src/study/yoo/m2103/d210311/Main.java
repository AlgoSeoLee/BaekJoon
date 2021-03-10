package study.yoo.m2103.d210311;

import java.util.Scanner;

//서버실
//https://www.acmicpc.net/problem/17245
public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[][] arr = new long[N][N];
		long max = 0;
		long ServerCom = 0; // 정상동작하는 서버컴 대수
		long answer = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextLong();
				max = Math.max(max, arr[i][j]);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				ServerCom += arr[i][j];
			}

		}

		long left = 1;
		long right = max;

		while (left <= right) {
			long mid = (left + right) / 2;
			long sum = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sum += arr[i][j] <= mid ? arr[i][j] : mid;
				}
			}

			if (sum >= ((ServerCom % 2 == 0 ? (ServerCom / 2) : (ServerCom / 2 + 1)))) {
				right = mid - 1;
				answer = mid;
			} else {
				left = mid + 1;
			}
		}

		System.out.println(answer);

	}
}
