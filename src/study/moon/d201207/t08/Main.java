package study.moon.d201207.t08;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
//https://www.acmicpc.net/problem/11050
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long[] factorial = new long[11];
        factorial[0] = 1;
        factorial[1] = 1;
        for (int i = 2; i <= 10; i++) {
            factorial[i] = factorial[i-1] * i;
        }

        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int k = Integer.parseInt(split[1]);

        long answer = factorial[n] / (factorial[n-k] * factorial[k]);
        bw.write(answer+"");
        bw.flush();
        bw.close();
    }
}
