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

    static int dfs(int x, int left, int right) {
        if (x == arr.length) {
            return 0;
        }
        if (dp[x][left][right] != 0) {
            return dp[x][left][right];
        }

        int goLeft = dfs(x + 1, arr[x], right) + going(left, arr[x]);
        int goRight = dfs(x + 1, left, arr[x]) + going(right, arr[x]);

        return dp[x][left][right] = Math.min(goLeft, goRight);
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
