package study.moon.d201102.t01;

import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        BigInteger[][] dp = new BigInteger[n+2][10];
        for (int i = 0; i < 10; i++) {
            dp[1][i] = BigInteger.valueOf(1);
        }
        for (int i = 2; i <= n+1; i++) {
            for (int j = 0; j < 10; j++) {
                BigInteger count = new BigInteger("0");
                for (int k = 0; k < 10 - j; k++) {
                    count = count.add(dp[i-1][9-k]);
                }
                dp[i][j] = count;
            }
        }
        System.out.println(dp[n+1][0].remainder(BigInteger.valueOf(10007)));
    }
}
