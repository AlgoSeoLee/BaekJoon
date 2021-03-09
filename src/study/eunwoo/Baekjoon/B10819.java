package study.eunwoo.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// [10819 차이를 최대로] https://www.acmicpc.net/problem/10819
public class B10819 {
    private static int n;
    private static int [] arr;
    private static boolean [] visited;
    private static int [] temp;
    private static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        temp = new int[n];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        dfs(0);

        System.out.println(answer);
    }

    private static void dfs(int depth) {
        if (depth == n) {
            int result = 0;

            for (int i = 0; i < n-1; i++) {
                result += Math.abs(temp[i] - temp[i+1]);
            }

            answer = Math.max(result, answer);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                temp[depth] = arr[i];
                dfs(depth+1);
                visited[i] = false;
            }
        }
    }
}
