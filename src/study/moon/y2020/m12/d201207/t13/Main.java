package study.moon.y2020.m12.d201207.t13;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
//https://www.acmicpc.net/problem/10951
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = "";
        while((str=br.readLine())!=null) {
            String[] split = str.split(" ");
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);
            bw.write((a + b) +"\n");
        }
        bw.flush();
        bw.close();
    }
}
