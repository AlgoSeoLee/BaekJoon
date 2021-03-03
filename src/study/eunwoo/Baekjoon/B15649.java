package study.eunwoo.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [15649 N과 M (1)] https://www.acmicpc.net/problem/15649
public class B15649 {
    private static int n, m;
    private static boolean [] check;
    private static int [] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        check = new boolean[n];
        arr = new int[m];

        dfs(0);
    }

    private static void dfs(int depth) {
        if (depth == m) {
            for (int i: arr) {
                System.out.print(i+" ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!check[i]) {
                check[i] = true;

                arr[depth] = i + 1;
                dfs(depth + 1);

                check[i] = false;
            }
        }
    }
}
