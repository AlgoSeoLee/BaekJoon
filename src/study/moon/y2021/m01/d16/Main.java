package study.moon.y2021.m01.d16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//https://www.acmicpc.net/problem/1806    [G4]    부분합
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int S = Integer.parseInt(s[1]);
        int[] arr = new int[N];
        s = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        int p1 = 0;
        int p2 = 0;
        int length = N + 1;

        while (p2 != N) {
            int sum = 0;
            for (int i = p2; i <= p1; i++) {
                sum += arr[i];
            }
            if (sum < S) {
                if (p1 == N - 1) {
                    break;
                }
                p1++;
            } else {
                if (p1 - p2 + 1 < length) {
                    length = p1 - p2 + 1;
                }
                p2++;
            }
        }
        if (length == N + 1) {
            bw.write("0");
        } else {
            bw.write(length + "");
        }
        bw.flush();
        bw.close();

    }
}
