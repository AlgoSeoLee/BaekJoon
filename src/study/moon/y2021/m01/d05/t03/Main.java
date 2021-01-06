package study.moon.y2021.m01.d05.t03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            //input
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(s[j]);
            }

            //logic
            long sum = 0;
            int max = Integer.MIN_VALUE;
            for (int j = n - 1; j >= 0; j--) {
                if (arr[j] > max) {
                    max = arr[j];
                } else {
                    sum += max - arr[j];
                }
            }
            bw.write("#"+(i+1)+" "+sum+"\n");
        }
        bw.flush();
        bw.close();
    }
}
