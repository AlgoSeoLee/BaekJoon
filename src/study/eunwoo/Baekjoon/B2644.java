package study.eunwoo.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// [2644 촌수계산] https://www.acmicpc.net/problem/2644
public class B2644 {
    private static ArrayList<ArrayList<Integer>> list;
    private static boolean [] visited;
    private static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String [] str = br.readLine().split(" ");
        int num1 = Integer.parseInt(str[0]);
        int num2 = Integer.parseInt(str[1]);

        int m = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        visited = new boolean[n+1];

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) { // 양방향 인접 리스트
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list.get(x).add(y);
            list.get(y).add(x);
        }

        dfs(num1, num2, 0);

        System.out.println(answer);
    }

    private static void dfs(int start, int end, int count) {
        visited[start] = true;

        for (int i: list.get(start)) {
            if (!visited[i]) {
                if (i == end) {
                    answer = count + 1;
                    return;
                }

                dfs(i, end, count+1);
            }
        }
    }
}
