package study.eunwoo.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [14888 연산자 끼워넣기] https://www.acmicpc.net/problem/14888
public class B14888 {
    private static int n;
    private static int [] arr;
    private static final int [] operator = new int[4];
    private static int min = Integer.MAX_VALUE;
    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        dfs(arr[0],1);

        System.out.println(max);
        System.out.println(min);
    }

    private static void dfs(int sum, int depth) {
        if (depth == n) {
            max = Math.max(sum, max);
            min = Math.min(sum, min);

            return;
        }

        for (int j = 0; j < 4; j++) {
            if (operator[j] > 0) {
                operator[j]--;

                switch (j) {
                    case 0: dfs(sum + arr[depth], depth+1); break;
                    case 1: dfs(sum - arr[depth], depth+1); break;
                    case 2: dfs(sum * arr[depth], depth+1); break;
                    case 3: dfs(sum / arr[depth], depth+1); break;
                }

                operator[j]++;
            }
        }
    }
}
