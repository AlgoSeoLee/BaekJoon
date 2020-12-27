package study.moon.y2020.m10.d201026.t04;

import java.io.*;

// https://www.acmicpc.net/problem/14890
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] split = br.readLine().split(" ");
        int size = Integer.parseInt(split[0]);
        int n = Integer.parseInt(split[1]);
        int[][] arr = new int[size][size];

        for (int i = 0; i < size; i++) {
            int floor = arr[i][0];
            for (int j = 0; j < size; j++) {
                if(arr[i][j] == floor) {
                    continue;
                }
                if(arr[i][j] + 1 == floor) {

                }

            }
        }
    }
}
