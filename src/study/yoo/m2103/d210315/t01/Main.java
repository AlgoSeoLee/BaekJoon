package study.yoo.m2103.d210315.t01;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int M, N, answer;
	static int[] arr;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		arr = new int[N];

		for (int i = 0; i < N; i++)
			arr[i] = sc.nextInt();

		Arrays.sort(arr);

		snack(1, arr[N - 1]);

		System.out.println(answer);

	}

	public static void snack(int s, int e) {
		if (s > e)
			return;
		int mid = (s + e) / 2;
		int count = 0;

		for (int i = 0; i < N; i++)
			count += arr[i] / mid;
		if (count >= M) {
			if (answer < mid)
				answer = mid;
			snack(mid + 1, e);
		} else {
			snack(s, mid - 1);
		}

	}

}
