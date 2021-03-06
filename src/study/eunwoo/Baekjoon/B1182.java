package study.eunwoo.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [1182 부분 수열의 합] https://www.acmicpc.net/problem/1182
public class B1182 {
    private static int n,s;
    private static int [] arr;
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        s = Integer.parseInt(str[1]);

        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        if (s == 0) {
            count--;
        }
        System.out.println(count);
    }

    private static void dfs(int depth, int sum) {
        if (depth == n) {
            if (sum == s) {
                count++;
            }
            return;
        }

        dfs(depth+1, arr[depth]+sum);
        dfs(depth+1, sum);
    }
}
