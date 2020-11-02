package study.moon.d201102.t03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        String[] s = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(s[i-1]);
        }
        int[][] dp = new int[n+1][2];
        int count0 = arr[1];
        dp[1][0] = 0;
        dp[1][1] = 1;

        for (int i = 2; i <=n ; i++) {
            if(count0 < arr[i]) {
                count0 += arr[i];
                dp[i][1] = dp[i-1][1]+1;
            } else {
                dp[i][0] = dp[i-1][0]+1;
            }
        }
        System.out.println(Math.max(dp[n][0],dp[n][1]));
    }
}
