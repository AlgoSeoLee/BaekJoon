package study.moon.d201203.t06;

import java.io.*;
import java.util.*;

//https://www.acmicpc.net/problem/1181
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = br.readLine();
        }
        Arrays.stream(strings)
                .sorted()
                .sorted(Comparator.comparingInt(String::length))
                .distinct()
                .forEach(v-> {
                    try {
                        bw.write(v+"\n");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
        bw.flush();
        bw.close();
    }
}
