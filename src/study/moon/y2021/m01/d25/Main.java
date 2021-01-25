package study.moon.y2021.m01.d25;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//https://www.acmicpc.net/problem/12865    [G5]    평범한 배낭
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");

        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);

        int[] W = new int[N + 1]; // 무게
        int[] V = new int[N + 1]; // 가치
        int[] dp = new int[K + 1];

        for (int i = 1; i <= N; i++) {
            s = br.readLine().split(" ");
            W[i] = Integer.parseInt(s[0]);
            V[i] = Integer.parseInt(s[1]);
        }

        for (int i = 1; i <= N; i++) {
            for (int j = K; j - W[i] >= 0; j--) {
                dp[j] = Math.max(dp[j], dp[j - W[i]] + V[i]);
            }
        }
        bw.write(dp[K]+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
