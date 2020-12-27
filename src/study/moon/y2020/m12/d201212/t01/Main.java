package study.moon.y2020.m12.d201212.t01;

import java.io.*;
//https://www.acmicpc.net/problem/5525
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m, ans;
    static int[] dp;
    static String s;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        s = br.readLine();

        dp = new int[m];
        for (int i = 2; i < m; i++) {
            if (s.substring(i-2, i+1).equals("IOI")) {
                dp[i] = dp[i-2] + 1;
            }

            if (dp[i] >= n) {
                ans++;
            }
        }

        System.out.println(ans);
    }
}

