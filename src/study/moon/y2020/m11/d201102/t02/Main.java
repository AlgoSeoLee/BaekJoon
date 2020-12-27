package study.moon.y2020.m11.d201102.t02;

import java.io.*;

//https://www.acmicpc.net/problem/9465
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][m+1];
            String[] s = br.readLine().split(" ");
            for (int j = 1; j <= m; j++) {
                arr[0][j] = Integer.parseInt(s[j-1]);
            }
            s = br.readLine().split(" ");
            for (int j = 1; j <= m; j++) {
                arr[1][j] = Integer.parseInt(s[j-1]);
            }
            int[][] dp = new int[m+1][3];
            dp[1][0] = 0;
            dp[1][1] = arr[0][1];
            dp[1][2] = arr[1][1];

            for(int j=2; j<=m; j++) {
                dp[j][0] = Math.max(dp[j-1][0], Math.max(dp[j-1][1], dp[j-1][2]));
                dp[j][1] = Math.max(dp[j-1][0], dp[j-1][2])+arr[0][j];
                dp[j][2] = Math.max(dp[j-1][0], dp[j-1][1])+arr[1][j];
            }
            bw.write((Math.max(dp[m][0], Math.max(dp[m][1], dp[m][2]))+"\n"));
        }
        bw.flush();
        bw.close();
    }
}
