package study.moon.y2021.m01.d13.t01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//https://www.acmicpc.net/problem/2467    [G5]    용액
public class Main {

    public static void main(String[] args) throws IOException {
        //given
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        int p1 = 0;
        int p2 = N - 1;
        int min = Math.abs(arr[p1] + arr[p2]);
        int answer1 = arr[p1];
        int answer2 = arr[p2];

        //when
        while (p1 != p2) {
            int abs = Math.abs(arr[p1] + arr[p2]);
            if (abs < min) {
                answer1 = arr[p1];
                answer2 = arr[p2];
                min = abs;
            }
            if (Math.abs(arr[p1 + 1] + arr[p2]) <= Math.abs(arr[p1] + arr[p2 - 1])) {
                p1++;
            } else {
                p2--;
            }
        }

        //then
        bw.write(answer1+" "+answer2);
        bw.flush();
        bw.close();
    }
}
