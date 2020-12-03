package study.moon.d201203.t01;

import java.io.*;
//https://www.acmicpc.net/problem/2675
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split(" ");
            int m = Integer.parseInt(split[0]);
            for (int j = 0; j < split[1].length(); j++) {
                for (int k = 0; k < m; k++) {
                    bw.write(split[1].charAt(j)+"");
                }
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
