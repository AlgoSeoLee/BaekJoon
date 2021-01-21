package study.moon.y2021.m01.d19;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/2473    [G4]   세 용액
class Main {

    static long[] answer = new long[3];
    static long max = 3000000000L;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];

        String[] s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(s[i]);
        }

        Arrays.sort(arr);

        for (int i = 0; i < n - 2; i++) {
            solution(arr, i);
        }

        Arrays.sort(answer);

        for (int i = 0; i < 3; i++) {
            bw.write(answer[i]+" ");
        }
        bw.flush();
        bw.close();
    }

    static void solution(long[] arr, int index) {
        int left = index + 1;
        int right = arr.length - 1;

        while (left < right) {
            long sum = arr[left] + arr[right] + arr[index];
            long absSum = Math.abs(sum);

            // 두 용액 갱신
            if (absSum < max) {
                answer[0] = arr[left];
                answer[1] = arr[right];
                answer[2] = arr[index];
                max = absSum;
            }

            if (sum > 0) {
                right--;
            } else {
                left++;
            }
        }
    }
}
