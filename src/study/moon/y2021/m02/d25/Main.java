package study.moon.y2021.m02.d25;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//https://www.acmicpc.net/problem/1034    [G5]    램프
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);

        int[][] arr = new int[n][m];
        String[] origin = new String[n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            origin[i] = s;
            for (int j = 0; j < m; j++) {
                arr[i][j] = Character.getNumericValue(s.charAt(j));
            }
        }

        int k = Integer.parseInt(br.readLine());
        boolean[] check = new boolean[n];
        int max = 0;

        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    cnt++;
                }
            }
            if ((cnt % 2 == k % 2) && cnt <= k) {
                check[i] = true;
            }
        }

        for (int i = 0; i < n; i++) {
            if (check[i]) {
                int cnt = 0;
                for (int j = 0; j < n; j++) {
                    if (origin[i].equals(origin[j])) {
                        cnt++;
                    }
                }
                if (max < cnt) {
                    max = cnt;
                }
            }
        }
        bw.write(max + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
