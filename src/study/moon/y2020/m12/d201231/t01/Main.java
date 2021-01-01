package study.moon.y2020.m12.d201231.t01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        int[][] arr = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            s = br.readLine().split(" ");
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(s[j-1]);
            }
        }

        int[][] dp = new int[n+1][n+1];
        dp[1][1] = arr[1][1];
        for (int i = 2; i <= n; i++) {
            dp[1][i] = dp[1][i-1] + arr[1][i];
        }
        for (int i = 2; i <= n; i++) {
            dp[i][1] = dp[i-1][1] + arr[i][1];
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= n; j++) {
                dp[i][j] = dp[i-1][j]+dp[i][j-1]-dp[i-1][j-1]+arr[i][j];
            }
        }




        for (int i = 0; i < m; i++) {
            int answer = 0;
            s = br.readLine().split(" ");
            int x1 = Integer.parseInt(s[0]);
            int y1 = Integer.parseInt(s[1]);
            int x2 = Integer.parseInt(s[2]);
            int y2 = Integer.parseInt(s[3]);

            answer = dp[x2][y2]-dp[x1-1][y2]-dp[x2][y1-1]+dp[x1-1][y1-1];

            bw.write(answer+"\n");
        }
        bw.flush();
        bw.close();
    }
}
