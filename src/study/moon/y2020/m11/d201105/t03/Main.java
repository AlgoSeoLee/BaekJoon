package study.moon.y2020.m11.d201105.t03;

import java.io.*;

//https://www.acmicpc.net/problem/1003
public class Main {
    static int[] dp0;
    static int[] dp1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        dp0 = new int[41];
        dp1 = new int[41];

        dp0[0] = 1;
        dp1[0] = 0;

        dp0[1] = 0;
        dp1[1] = 1;

        for (int i = 2; i <= 40; i++) {
            dp0[i] = dp0[i - 1] + dp0[i - 2];
            dp1[i] = dp1[i - 1] + dp1[i - 2];
        }
        for (int i = 0; i < n; i++) {
            int dp = Integer.parseInt(br.readLine());
            bw.write(dp0[dp]+" "+dp1[dp]+"\n");
        }
        bw.flush();
        bw.close();
    }
}
