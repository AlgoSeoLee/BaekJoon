package study.moon.y2021.m01.d12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//https://www.acmicpc.net/problem/12852    [S1]    1로 만들기(2)
public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        dp = new int[N + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
        }
        bw.write(dp[N] + "\n");
        print(N);

        bw.flush();
        bw.close();
    }

    private static void print(int N) throws IOException {
        bw.write(N + " ");
        if (N - 1 >= 0 && dp[N - 1] == dp[N] - 1) {
            print(N - 1);
        } else if (N % 3 == 0 && dp[N / 3] == dp[N] - 1) {
            print(N / 3);
        } else if (N % 2 == 0 && dp[N / 2] == dp[N] - 1) {
            print(N / 2);
        }
    }
}
