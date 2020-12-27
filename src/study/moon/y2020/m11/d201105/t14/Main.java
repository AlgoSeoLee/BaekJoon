package study.moon.y2020.m11.d201105.t14;

import java.io.*;

//https://www.acmicpc.net/problem/11719
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s;
        while((s = br.readLine()) != null) {
            bw.write(s+"\n");
        }
        bw.flush();
        bw.close();
    }
}

