package study.moon.d201203.t02;

import java.io.*;

//https://www.acmicpc.net/problem/2908
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] split = br.readLine().split(" ");
        int[] answer = new int[2];
        for (int i = 0; i < 2; i++) {
            StringBuilder str = new StringBuilder();
            for (int j = split[i].length()-1; j >= 0; j--) {
                str.append(split[i].charAt(j));
            }
            answer[i] = Integer.parseInt(str.toString());
        }

        bw.write(Math.max(answer[0],answer[1])+"");
        bw.flush();
        bw.close();
    }
}
