package study.eunwoo.Baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// [7576 토마토] https://www.acmicpc.net/problem/7576
public class B7576 {
    private static final int [] dx = { -1, 1, 0, 0 }; // 상하좌우
    private static final int [] dy = { 0, 0, -1, 1 };
    private static int n,m;
    private static int [][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        bfs();
    }

    private static void bfs() {
        Queue<int []> q = new LinkedList<>();

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                if (map[x][y] == 1) {
                    q.offer(new int[]{x, y});
                }
            }
        }

        while (!q.isEmpty()) {
            int curX = q.peek()[0];
            int curY = q.peek()[1];
            q.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = curX + dx[dir];
                int ny = curY + dy[dir];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (map[nx][ny] == 0) {
                        q.offer(new int[]{nx, ny});
                        map[nx][ny] = map[curX][curY] + 1;
                    }
                }
            }
        }

        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }

                max = Math.max(map[i][j], max);
            }
        }

        System.out.println(max-1);
    }
}
