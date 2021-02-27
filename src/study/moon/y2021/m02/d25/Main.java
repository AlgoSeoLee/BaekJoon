package study.moon.y2021.m02.d25;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//https://www.acmicpc.net/problem/1034    [G5]    램프
public class Main {
    static int[][] arr;
    static int n;
    static int m;
    static int k;

    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] split = br.readLine().split(" ");
        n = Integer.parseInt(split[0]);
        m = Integer.parseInt(split[1]);

        arr = new int[n][m];

        k = Integer.parseInt(br.readLine());

        dfs(0);
        bw.write(answer+"");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int count) {
        if (count == k) {
            int result = getOnColumn();
            if (result>answer) {
                answer = result;
            }
            return;
        }

        for (int i = 0; i < m; i++) {
            reverseRow(i);
            dfs(count+1);
            reverseRow(i);
        }
    }

    private static void reverseRow(int row) {
        for (int i = 0; i < n; i++) {
            arr[i][row] = 1 - arr[i][row];
        }

        for (int j = 0; j < n; j++) {
            for (int l = 0; l < m; l++) {
                System.out.print(arr[j][l]);
            }
            System.out.println();
        }
        System.out.println();
    }

    private static int getOnColumn() {
        int result = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < m; j++) {
                if (arr[i][j]==1) {
                    count++;
                }
            }
            if (count == m) {
                result++;
            }
        }
        return result;
    }

}
