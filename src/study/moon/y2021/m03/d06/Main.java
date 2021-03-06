package study.moon.y2021.m03.d06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//https://www.acmicpc.net/problem/1562    [G1]    계단수
public class Main {

    static int N;
    static int visit = 1 << 10;
    static int mod = 1000000000;
    static long[][][] dp = new long[101][10][visit];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        bw.write(calc() + "");
        bw.flush();
        bw.close();
        br.close();
    }

    private static long calc() {
        long sum = 0;

        for (int i = 1; i < 10; i++) {
            dp[1][i][1 << i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k < visit; k++) {
                    int bit = k | (1 << j);
                    dp[i][j][bit] = (dp[i][j][bit] + ((0 < j ? dp[i - 1][j - 1][k] : 0) + (j < 9 ? dp[i - 1][j + 1][k] : 0)) % mod) % mod;
                }
            }
        }
        for (int i = 0; i < 10; i++) {
            sum = (sum + dp[N][i][visit - 1]) % mod;
        }
        return sum;
    }
}
