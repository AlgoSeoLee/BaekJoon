package study.moon.y2020.m12.d201210.t03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://www.acmicpc.net/problem/1764
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        String[] strings = new String[n];
        List<String> answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            strings[i] = br.readLine();
        }

        Arrays.sort(strings);
        for (int i = 0; i < m; i++) {
            String s1 = br.readLine();
            int i1 = Arrays.binarySearch(strings, s1);
            if (i1 > -1) {
                answer.add(strings[i1]);
            }
        }
        System.out.println(answer.size());
        answer.sort(String::compareToIgnoreCase);
        for (String value : answer) {
            System.out.println(value);
        }
    }
}
