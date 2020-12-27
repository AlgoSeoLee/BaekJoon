package study.moon.y2020.m12.d201212.t02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
//https://www.acmicpc.net/problem/6064
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String[] s = br.readLine().split(" ");
            int m = Integer.parseInt(s[0]);
            int n = Integer.parseInt(s[1]);
            int x = Integer.parseInt(s[2]);
            int y = Integer.parseInt(s[3]);

            int LCM = getLCM(m,n,m,n);
            List<Integer> list = new ArrayList<>();
            int count = x;
            for (int j = 0; count <= LCM; j++) {
                list.add(m * j + x);
                count+=m;
            }
            count = 0;
            for (int number : list) {
                if (y==n) {
                    y = 0;
                }
                if (number % n == y) {
                    count++;
                    bw.write(number + "\n");
                }
            }
            if (count == 0) {
                bw.write("-1\n");
            }
        }
        bw.flush();
        bw.close();

    }

    private static int getLCM(int a, int b, final int num1, final int num2) {
        if (a == b) {
            return a;
        }

        if (a > b) {
            return getLCM(a, b + num2, num1, num2);
        }

        return getLCM(a + num1, b, num1, num2);
    }
}
