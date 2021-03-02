package study.eunwoo.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [6603 로또] https://www.acmicpc.net/problem/6603
public class B6603 {
    private static int k;
    private static int [] numbers;
    private static boolean [] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        do {
            st = new StringTokenizer(br.readLine());

            k = Integer.parseInt(st.nextToken());

            numbers = new int[k];
            check = new boolean[k];

            for (int i = 0; i < k; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0);

            System.out.println();

        } while (k != 0);

    }

    private static void dfs(int start, int depth) {
        if (depth == 6) {
            for (int i=0; i<k; i++) {
                if (check[i])
                    System.out.print(numbers[i]+" ");
            }
            System.out.println();
        }

        for (int i=start; i<k; i++) {
            check[i] = true;
            dfs(i+1, depth+1);
            check[i] = false;
        }
    }
}
