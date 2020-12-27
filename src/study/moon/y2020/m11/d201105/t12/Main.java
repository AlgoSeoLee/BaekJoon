package study.moon.y2020.m11.d201105.t12;

import java.io.*;
//https://www.acmicpc.net/problem/1157
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        s = s.toUpperCase();
        int[] answer = new int[26];
        int maxNum = 0;
        for (int i = 0; i < s.length(); i++) {
            answer[s.charAt(i) - 65]++;
        }
        for (int i = 0; i < 26; i++) {
            if(answer[i] > maxNum) {
                maxNum = answer[i];
            }
        }
        bw.write(getChar(answer,maxNum));
        bw.flush();
        bw.close();
    }

    public static char getChar(int[] arr, int maxNum) {
        int count = 0;
        char c = ' ';
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == maxNum) {
                c = (char)(i+65);
                count++;
            }
        }
        if(count>=2) {
            return '?';
        } else {
            return c;
        }
    }
}
