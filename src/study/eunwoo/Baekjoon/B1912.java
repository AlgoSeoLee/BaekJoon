package study.eunwoo.Baekjoon;

import java.util.Scanner;

// [1912 연속합] https://www.acmicpc.net/problem/1912
public class B1912 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int [] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = sc.nextInt();
        }

        int max = dp[0];

        for (int i = 1; i < n; i++) {

            if (dp[i-1] > 0 && dp[i-1] + dp[i] > 0)
                dp[i] += dp[i-1];

            max = Math.max(dp[i], max);
        }

        System.out.println(max);
    }
}
