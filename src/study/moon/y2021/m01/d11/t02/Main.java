package study.moon.y2021.m01.d11.t02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//https://www.acmicpc.net/problem/12849    [S1]    본대 산책
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int D = Integer.parseInt(br.readLine());

        long[] dp = new long[8];
        dp[0] = 1;

        for (int i = 0; i < D; i++) {
            dp = move(dp);
        }
        bw.write(dp[0]+"");
        bw.flush();
        bw.close();
    }

    private static long[] move(long[] dp) {
        // 0: 정보과학관
        // 1: 전산관
        // 2: 미래관
        // 3: 신양관
        // 4: 한경직 기념관
        // 5: 진리관
        // 6: 학생회관
        // 7: 형남공학관
        long[] arr = new long[8];
        arr[0] = dp[1] + dp[2];
        arr[1] = dp[0] + dp[2] + dp[3];
        arr[2] = dp[0] + dp[1] + dp[3] + dp[4];
        arr[3] = dp[1] + dp[2] + dp[4] + dp[5];
        arr[4] = dp[2] + dp[3] + dp[5] + dp[7];
        arr[5] = dp[3] + dp[4] + dp[6];
        arr[6] = dp[5] + dp[7];
        arr[7] = dp[4] + dp[6];

        for (int i = 0; i < 8; i++) {
            arr[i] %= 1_000_000_007;
        }
        return arr;
    }
}
