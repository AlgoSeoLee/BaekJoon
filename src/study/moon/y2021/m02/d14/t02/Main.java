package study.moon.y2021.m02.d14.t02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//https://www.acmicpc.net/problem/1030    [G3]    프랙탈 평면
public class Main {
    static int s, n, k, r1, r2, c1, c2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] strings = br.readLine().split(" ");
        s = Integer.parseInt(strings[0]);
        n = Integer.parseInt(strings[1]);
        k = Integer.parseInt(strings[2]);
        r1 = Integer.parseInt(strings[3]);
        r2 = Integer.parseInt(strings[4]);
        c1 = Integer.parseInt(strings[5]);
        c2 = Integer.parseInt(strings[6]);

        if (s == 0) {
            System.out.println("0");
            System.exit(0);
        }

        int len = 1;
        do {
            s--;
            len *= n;
        } while (s!=0);

        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                System.out.print(func(len, i, j));
            }
            System.out.println();
        }
    }

    static int func(int len, int x, int y) {
        if (len == 1) {
            return 0;
        }
        int border = len / n;
        if (x >= border * (n - k) / 2
            && x < border * (n + k) / 2
            && y >= border * (n - k) / 2
            && y < border * (n + k) / 2
        ) {
            return 1;
        }
        return func(border, x % border, y % border);
    }
}
