package study.moon.y2020.m11.d201112.t03;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

//https://www.acmicpc.net/problem/1946
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int answer = 0;
            int m =Integer.parseInt(br.readLine());
            int[][] score = new int[m][2];
            for (int j = 0; j < m; j++) {
                String[] split = br.readLine().split(" ");
                score[j][0] = Integer.parseInt(split[0]);
                score[j][1] = Integer.parseInt(split[1]);
            }

            Arrays.sort(score, Comparator.comparingInt(arr -> arr[0]));

            int point = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++) {
                if(score[j][1] < point) {
                    point = score[j][1];
                    answer++;
                }
            }
            bw.write(answer+"\n");
        }
        bw.flush();
        bw.close();
    }
}
