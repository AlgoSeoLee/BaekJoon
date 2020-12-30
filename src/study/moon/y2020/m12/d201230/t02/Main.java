package study.moon.y2020.m12.d201230.t02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            arr[i + 1] = Integer.parseInt(s[i]);
            dp[i + 1] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (arr[i] < arr[j]) {
                    if (dp[i] <= dp[j]) {
                        dp[i] = dp[j] + 1;
                    }
                }
            }
        }

        int answer = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            if (dp[i] > answer) {
                answer = dp[i];
            }
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
    }

}

