package study.moon.y2021.m03.d07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//https://www.acmicpc.net/problem/1052    [S1]    물병
public class Main {

    public static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);

        count = Integer.bitCount(n);
        int mergedWater = (int) Math.pow(2, Integer.toBinaryString(n).length() - 1);
        int leftWater = n - mergedWater;
        int newWater = 0;

        while (count > k && mergedWater > leftWater) {
            leftWater += 1;
            newWater += 1;
            count = Integer.bitCount(leftWater) + 1;
        }

        bw.write(newWater + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
