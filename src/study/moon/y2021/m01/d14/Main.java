package study.moon.y2021.m01.d14;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
//https://www.acmicpc.net/problem/9252    [G5]    LCS2
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] arr1 = br.readLine().toCharArray();
        char[] arr2 = br.readLine().toCharArray();
        int n = arr1.length;
        int m = arr2.length;

        int[][] dp = new int[n + 1][m + 1];
        String[][] dp2 = new String[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp2[i][j]="";
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (arr1[i - 1] == arr2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    dp2[i][j] = dp2[i - 1][j - 1] + arr2[j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    if (dp2[i - 1][j].length() > dp2[i][j - 1].length()) {
                        dp2[i][j] = dp2[i - 1][j];
                    } else {
                        dp2[i][j] = dp2[i][j - 1];
                    }
                }
            }
        }

        bw.write(dp[n][m] + "\n");
        bw.write(dp2[n][m]+"");
        bw.flush();
        bw.close();
    }
}
