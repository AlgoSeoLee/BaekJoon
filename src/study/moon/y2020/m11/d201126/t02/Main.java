package study.moon.y2020.m11.d201126.t02;

import java.io.*;
import java.util.Arrays;

// https://www.acmicpc.net/problem/2437
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] split = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }
        Arrays.sort(arr);

        int min = 1;
        for(int i = 0 ; i < n; i++) {
            if(min < arr[i]) {
                break;
            }
            min += arr[i];
        }

        System.out.println(min);
    }
}
