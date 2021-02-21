package study.moon.y2021.m02.d21;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//https://www.acmicpc.net/problem/1138    [S2]    한줄로서기
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        int[] answer = new int[N];
        String[] s = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(s[i-1]);
        }
        for (int i = 1; i < arr.length; i++) {
            if (answer[arr[i]] == 0) {
                answer[arr[i]] = i;
            } else {

            }
        }
    }
}
