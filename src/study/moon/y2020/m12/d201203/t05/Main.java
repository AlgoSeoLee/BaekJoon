package study.moon.y2020.m12.d201203.t05;

import java.io.*;
//https://www.acmicpc.net/problem/1085
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] split = br.readLine().split(" ");
        int x = Integer.parseInt(split[0]);
        int y = Integer.parseInt(split[1]);
        int w = Integer.parseInt(split[2]);
        int h = Integer.parseInt(split[3]);

        bw.write(Math.min(Math.min(w - x, x), Math.min(h - y, y)) + "");
        bw.flush();
        bw.close();
    }
}
