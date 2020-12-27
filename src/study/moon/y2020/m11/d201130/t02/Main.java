package study.moon.y2020.m11.d201130.t02;

import java.io.*;

//https://www.acmicpc.net/problem/1546
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        String[] split = br.readLine().split(" ");
        for (int i = 0; i < split.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }
        int M = getMax(arr);

        double[] answer = new double[n];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = (double)arr[i] / M * 100;
        }
        bw.write(getAverage(answer)+"");
        bw.flush();
        bw.close();
    }

    private static int getMax(int[] arr) {
        int MAX = Integer.MIN_VALUE;
        for (int i : arr) {
            MAX = Math.max(MAX,i);
        }
        return MAX;
    }

    private static double getAverage(double[] arr) {
        double sum = 0;
        for (double v : arr) {
            sum += v;
        }
        return sum/arr.length;
    }
}
