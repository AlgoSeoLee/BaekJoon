package study.moon.d201217.t01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
//https://www.acmicpc.net/problem/11723
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Set<String> set = new HashSet<>();
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            String[] s = br.readLine().split(" ");

            if (s[0].equals("add")) {
                set.add(s[1]);
            }
            if (s[0].equals("remove")) {
                set.remove(s[1]);
            }
            if (s[0].equals("check")) {
                if (set.contains(s[1])) {
                    bw.write("1\n");
                }else {
                    bw.write("0\n");
                }
            }
            if (s[0].equals("toggle")) {
                if (set.contains(s[1])) {
                    set.remove(s[1]);
                }else {
                    set.add(s[1]);
                }
            }
            if (s[0].equals("all")) {
                for (int j = 1; j <= 20; j++) {
                    set.add(String.valueOf(j));
                }
            }
            if (s[0].equals("empty")) {
                set.clear();
            }
        }
        bw.flush();
        bw.close();
    }

}
