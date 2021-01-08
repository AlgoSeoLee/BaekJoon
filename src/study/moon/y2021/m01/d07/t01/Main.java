package study.moon.y2021.m01.d07.t01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//https://www.acmicpc.net/problem/17070    [G5]    파이프 옮기기1    <발표>
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(s[j-1]);
            }
        }

        int[][][] dp = new int[N+1][N+1][3];
        dp[1][1][0] = 1;
        for (int i = 1; i <= N; i++) {
            for (int j = 2; j <= N; j++) {
                if (j + 1 <= N && arr[i][j+1]!=1) {
                    dp[i][j][0] = dp[i][j-1][0] + dp[i-1][j-1][2];
                }
                if (i + 1 <= N && arr[i+1][j]!=1) {
                    dp[i][j][1] = dp[i-1][j][1] + dp[i-1][j-1][2];
                }
                if (i + 1 <= N
                    && j+1 <= N
                    && arr[i][j+1]!=1
                    && arr[i+1][j]!=1
                    && arr[i+1][j+1]!=1) {
                    dp[i][j][2] = dp[i][j-1][0] + dp[i-1][j][1] + dp[i-1][j-1][2];
                }
            }
        }
        int answer = dp[N][N-1][0] + dp[N-1][N][1] + dp[N-1][N-1][2];
        bw.write(answer+"");
        bw.flush();
        bw.close();
    }
}
