package study.eunwoo.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// [10026 적록색약] https://www.acmicpc.net/problem/10026
public class B10026 {
    private static final int [] dx = { -1, 1, 0, 0 }; // 상하좌우
    private static final int [] dy = { 0, 0, -1, 1 };
    private static int n;
    private static char [][] map;
    private static boolean [][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new char[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();

            for (int j = 0; j < n; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        int answer1 = 0;
        int answer2 = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, false);
                    answer1++;
                }
            }
        }

        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, true);
                    answer2++;
                }
            }
        }

        System.out.print(answer1+" "+answer2);
    }

    private static void bfs(int x, int y, boolean check) {
        Queue<int []> q = new LinkedList<>();
        q.offer(new int[]{x ,y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int curX = q.peek()[0];
            int curY = q.peek()[1];
            q.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = curX + dx[dir];
                int ny = curY + dy[dir];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {

                    if (!check) {
                        if (map[nx][ny] == map[x][y] && !visited[nx][ny]) {
                            q.offer(new int[]{nx, ny});
                            visited[nx][ny] = true;
                        }
                    } else {
                        if (map[x][y] == 'G' || map[x][y] == 'R') {
                            if (!visited[nx][ny] && (map[nx][ny] == 'G' || map[nx][ny] == 'R')) {
                                q.offer(new int[]{nx, ny});
                                visited[nx][ny] = true;
                            }
                        } else if (map[nx][ny] == 'B' && !visited[nx][ny]) {
                            q.offer(new int[]{nx, ny});
                            visited[nx][ny] = true;
                        }
                    }
                }
            }
        }
    }
}
