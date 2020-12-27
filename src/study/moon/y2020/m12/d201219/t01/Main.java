package study.moon.y2020.m12.d201219.t01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
//https://www.acmicpc.net/problem/17219
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        Map<String,String> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] s1 = br.readLine().split(" ");
            map.put(s1[0],s1[1]);
        }
        for (int i = 0; i < m; i++) {
            String s1 = br.readLine();
            bw.write(map.get(s1)+"\n");
        }
        bw.flush();
        bw.close();
    }

}
