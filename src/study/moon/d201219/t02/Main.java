package study.moon.d201219.t02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
//https://www.acmicpc.net/problem/17626
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];

        dp[1] = 1;

        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            int range = (int) Math.sqrt(i);
            for (int j = 1; j <= range; j++) {
                min = Math.min(min, dp[i - j * j]);
            }
            dp[i] = dp[min] + 1;
        }

        bw.write(dp[n] + "");
        bw.flush();
        bw.close();
    }

}
