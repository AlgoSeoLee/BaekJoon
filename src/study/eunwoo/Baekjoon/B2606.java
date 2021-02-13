package study.eunwoo.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// [2606 바이러스] https://www.acmicpc.net/problem/2606
public class B2606 {
    private static int n;
    private static int [][] map;
    private static boolean [] visited;
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        map = new int[n+1][n+1];
        visited = new boolean[n+1];

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x][y] = map[y][x] = 1;
        }

        bfs();

        System.out.println(count);
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visited[1] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int j = 1; j <= n; j++) {
                if (map[cur][j] == 1 && !visited[j]) {
                    q.offer(j);
                    visited[j] = true;
                    count++;
                }
            }
        }
    }
}
