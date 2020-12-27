package study.moon.y2020.m11.d201105.t11;

import java.io.*;
import java.util.Arrays;

//https://www.acmicpc.net/problem/10809
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] alphabet = new int[26];
        Arrays.fill(alphabet, -1);
        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(alphabet[c-97] == -1) {
                alphabet[c-97] = i;
            }
        }
        bw.write(alphabet[0]+"");
        for (int i = 1; i < alphabet.length; i++) {
            bw.write(" " + alphabet[i]);
        }
        bw.flush();
        bw.close();
    }
}
