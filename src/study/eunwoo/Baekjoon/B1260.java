package study.eunwoo.Baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// [1260 DFS와 BFS] https://www.acmicpc.net/problem/1260
public class B1260 {
    static int [][] map;
    static boolean [] visited;
    static int n;
    static int m;
    static int start;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); // 정점 갯수
        m = sc.nextInt(); // 간선 갯수
        start = sc.nextInt(); // 시작점

        map = new int[1001][1001];
        visited = new boolean[1001];

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            map[x][y] = map[y][x] = 1;
        }

        dfs(start);

        System.out.println();
        visited = new boolean[1001];

        bfs();
    }

    static void dfs(int start) {
        visited[start] = true;
        System.out.print(start + " ");

        for (int j = 1; j <= n; j++) {
            if (map[start][j] == 1 && !visited[j]) {
                dfs(j);
            }
        }
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        System.out.print(start + " ");

        while (!q.isEmpty()) {
            int temp = q.poll();

            for (int j = 1; j <= n; j++) {
                if (map[temp][j] == 1 && !visited[j]) {
                    q.offer(j);
                    visited[j] = true;
                    System.out.print(j + " ");
                }
            }
        }
    }
}
