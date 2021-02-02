package study.moon.y2021.m01.d31;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//https://www.acmicpc.net/problem/2342    [G3]    DDR
class Main {

    static int[][][] dp;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        arr = new int[s.length - 1];
        for (int i = 0; i < s.length-1; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        dp = new int[arr.length][5][5];
        bw.write(dfs(0, 0, 0) + "");
        bw.flush();
        br.close();
        bw.close();
    }

    static int dfs(int depth, int left, int right) {
        if (depth == arr.length) {
            return 0;
        }
        if (dp[depth][left][right] != 0) {
            return dp[depth][left][right];
        }

        int goLeft = dfs(depth + 1, arr[depth], right) + going(left, arr[depth]);
        int goRight = dfs(depth + 1, left, arr[depth]) + going(right, arr[depth]);

        return dp[depth][left][right] = Math.min(goLeft, goRight);
    }

    static int going(int go, int to) {
        if (go == 0) {
            return 2;
        }
        if (Math.abs(go - to) == 2) {
            return 4;
        }
        if (go == to) {
            return 1;
        }
        return 3;
    }
}
