package study.eunwoo.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// [10974 모든 순열] https://www.acmicpc.net/problem/10974
public class B10974 {
    private static int n;
    private static int [] arr;
    private static boolean [] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        visited = new boolean[n];

        dfs(0);
    }

    private static void dfs(int depth) {
        if (depth == n) {
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i+1;
                dfs(depth+1);
                visited[i] = false;
            }
        }
    }
}
