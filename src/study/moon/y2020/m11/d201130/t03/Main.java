package study.moon.y2020.m11.d201130.t03;

import java.io.*;

//https://www.acmicpc.net/problem/2475
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] split = br.readLine().split(" ");
        int sum = 0;
        for (String s : split) {
            sum += (int)Math.pow(Integer.parseInt(s), 2);
        }
        bw.write((sum%10)+"");
        bw.flush();
        bw.close();
    }
}
