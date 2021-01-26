package study.moon.y2021.m01.d26;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//https://www.acmicpc.net/problem/2166    [G5]    다각현의 면적
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        double[] X = new double[N + 1];
        double[] Y = new double[N + 1];
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            X[i] = Double.parseDouble(s[0]);
            Y[i] = Double.parseDouble(s[1]);
        }
        X[N] = X[0];
        Y[N] = Y[0];

        double sum1 = 0;
        double sum2 = 0;
        for (int i = 0; i < N; i++) {
            sum1 += X[i] * Y[i + 1];
            sum2 += X[i + 1] * Y[i];
        }

        double answer = Math.abs(sum1 - sum2) / 2;
        bw.write(String.format("%.1f",answer));
        bw.flush();
        bw.close();
        br.close();

    }
}
