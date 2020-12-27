package study.moon.y2020.m12.d201227.t01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int r = Integer.parseInt(s[1]);
        BigInteger[][] arr = new BigInteger[101][101];
        arr[0][0] = BigInteger.valueOf(1);
        arr[1][0] = BigInteger.valueOf(1);
        arr[1][1] = BigInteger.valueOf(1);
        for (int i = 2; i <= n; i++) {
            arr[i][0] = BigInteger.valueOf(1);
            for (int j = 1; j < i; j++) {
                arr[i][j] = arr[i-1][j-1].add(arr[i-1][j]);
            }
            arr[i][i] = BigInteger.valueOf(1);
        }
        bw.write(arr[n][r]+"");
        bw.flush();
        bw.close();

    }
}
