package study.moon.y2021.m01.d08.t01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

//https://www.acmicpc.net/problem/11054    [G3]    가장 긴 바이토닉 부분 수열
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        String[] s = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(s[i - 1]);
        }
        int[] dp1 = new int[N + 1];
        int[] dp2 = new int[N + 1];
        int[] answer = new int[N + 1];

        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                if (arr[i] > arr[j]) {
                    if (dp1[i] <= dp1[j]) {
                        dp1[i] = dp1[j] + 1;
                    }
                }
            }
        }

        for (int i = N; i >= 1; i--) {
            for (int j = N; j >= i; j--) {
                if (arr[i] > arr[j]) {
                    if (dp2[i] <= dp2[j]) {
                        dp2[i] = dp2[j] + 1;
                    }
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            answer[i] = dp1[i] + dp2[i] - 1;
        }
        bw.write(getMax(answer) + "");
        bw.flush();
        bw.close();
    }

    private static int getMax(int[] arr) {
        int answer = 0;
        for (int j : arr) {
            if (j > answer) {
                answer = j;
            }
        }
        return answer;
    }
}
