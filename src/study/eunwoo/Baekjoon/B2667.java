package study.eunwoo.Baekjoon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// [2667 단지 번호 붙이기] https://www.acmicpc.net/problem/2667
public class B2667 {
    private static final int [] dx = { -1, 1, 0, 0 }; // 상하좌우
    private static final int [] dy = { 0, 0, -1, 1 };
    private static int n;
    private static int [][] map;
    private static boolean [][] visited;
    private static int apartNum = 0;
    private static final int [] aparts = new int[25*25];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String s = sc.next();

            for (int j = 0; j < n; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    apartNum++;
                    bfs(i, j);
                }
            }
        }

        Arrays.sort(aparts);
        System.out.println(apartNum);

        for (int apart : aparts) {
            if (apart > 0) {
                System.out.println(apart);
            }
        }
    }

    static void bfs(int x, int y) {
        Queue<int []> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;
        aparts[apartNum]++;

        while (!q.isEmpty()) {
            int curX = q.peek()[0];
            int curY = q.peek()[1];
            q.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = curX + dx[dir];
                int ny = curY + dy[dir];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    if (map[nx][ny] == 1 && !visited[nx][ny]) {
                        q.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        aparts[apartNum]++;
                    }
                }
            }
        }
    }
}
