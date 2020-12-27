package study.moon.y2020.m11.d201105.t15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//https://www.acmicpc.net/problem/1316
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if(isGroupWord(br.readLine())) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    public static boolean isGroupWord(String word) {
        if(word.length() == 1) {
            return true;
        }
        List<Character> list = new ArrayList<>();
        list.add(word.charAt(0));
        for (int i = 1; i < word.length(); i++) {
            if(word.charAt(i)!=word.charAt(i-1)) {
                if(list.contains(word.charAt(i))) {
                    return false;
                } else {
                    list.add(word.charAt(i));
                }
            }
        }
        return true;
    }
}
