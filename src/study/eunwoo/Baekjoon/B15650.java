package study.eunwoo.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [15650 N과 M (2)] https://www.acmicpc.net/problem/15650
public class B15650 {
    private static int n, m;
    private static int [] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];

        dfs(0, 0);
    }

    private static void dfs(int start, int depth) {
        if (depth == m) {
            for (int i: arr) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < n; i++) {
            arr[depth] = i + 1;
            dfs(i + 1, depth + 1);
        }
    }
}
