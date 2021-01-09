package study.moon.y2021.m01.d09.t02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//https://www.acmicpc.net/problem/18119    [G4]    단어암기    <발표>
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] alphabet = new int[26];
        alphabet[0] = 1;
        for (int i = 1; i < 26; i++) {
            alphabet[i] = alphabet[i-1] * 2;
        }
        int start = alphabet[25] * 2 - 1;

        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        int[] words = new int[N];
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            for (int j = 0; j < word.length(); j++) {
                words[i] = words[i] | alphabet[word.charAt(j) - 'a'];
            }
        }

        for (int i = 0; i < M; i++) {
            s = br.readLine().split(" ");

            if (s[0].equals("1")) {
                start -= alphabet[s[1].charAt(0) - 'a'];
            }

            if (s[0].equals("2")) {
                start += alphabet[s[1].charAt(0) - 'a'];
            }
            int number = 0;
            for (int j = 0; j < N; j++) {
                if ((start | words[j]) == start) {
                    number++;
                }
            }
            bw.write(number + "\n");
        }
        bw.flush();
        bw.close();
    }
}
