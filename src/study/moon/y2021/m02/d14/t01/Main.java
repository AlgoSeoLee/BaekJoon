package study.moon.y2021.m02.d14.t01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//https://www.acmicpc.net/problem/1030    [G3]    프랙탈 평면
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] strings = br.readLine().split(" ");
        int s = Integer.parseInt(strings[0]);
        int N = Integer.parseInt(strings[1]);
        int K = Integer.parseInt(strings[2]);
        int R1 = Integer.parseInt(strings[3]);
        int R2 = Integer.parseInt(strings[4]);
        int C1 = Integer.parseInt(strings[5]);
        int C2 = Integer.parseInt(strings[6]);
        Solution solution = new Solution();
        solution.solution(s, N, K, R1, R2, C1, C2);
        bw.flush();
        bw.close();
        br.close();
    }
}

class Solution {

    int[][] arr;

    public void solution(int s, int N, int K, int R1, int R2, int C1, int C2) {
        int range = (int)Math.pow(N, s);
        arr = new int[range][range];
        dfs(range, 0, 0, N, K*(int)Math.pow(N, s-1));
        for (int i = R1; i <= R2; i++) {
            for (int j = C1; j <= C2; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    private void dfs(int range, int startN, int startM, int N, int K) {
        if (range / N == 0) {
            return;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dfs(range / N, startN + range / N * i, startM + range / N * j, N, K / N);
            }
        }
        for (int i = startN + (range - K) / 2; i < startN +(range + K) / 2; i++) {
            for (int j = startM+(range - K) / 2; j < startM+(range + K) / 2; j++) {
                arr[i][j] = 1;
            }
        }
    }
}
