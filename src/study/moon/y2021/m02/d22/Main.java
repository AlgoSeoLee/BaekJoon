package study.moon.y2021.m02.d22;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

//https://www.acmicpc.net/problem/2110    [S1]    공유기 설치
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int c = Integer.parseInt(s[1]);
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        int ans = 1;
        int start = 1;
        int end = arr[n - 1] - arr[0]; //가능한 최대 거리

        while (start <= end) {
            int mid = (start + end) >>> 1;
            if (check(arr, mid, c)) {
                ans = Math.max(ans, mid);
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        bw.write(ans+"");
        bw.flush();
        bw.close();
    }

    static boolean check(int[] arr, int dist, int c) {
        int cnt = 1;
        int last = arr[0] + dist; //첫 번째 값 + 거리
        for (int j : arr) {
            if (j >= last) {
                cnt++;
                last = j + dist; //마지막 값 + 거리
            }
        }
        return cnt >= c;
    }
}
