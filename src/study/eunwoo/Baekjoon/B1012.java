package study.eunwoo.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// [1012 유기농 배추] https://www.acmicpc.net/problem/1012
public class B1012 {
    private static final int [] dx = { -1, 1, 0, 0 }; // 상하좌우
    private static final int [] dy = { 0, 0, -1, 1 };
    private static int n,m;
    private static int [][] map;
    private static boolean [][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t != 0) {
            String [] str = br.readLine().split(" ");
            n = Integer.parseInt(str[0]);
            m = Integer.parseInt(str[1]);
            int k = Integer.parseInt(str[2]);

            map = new int[n][m];
            visited = new boolean[n][m];

            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                map[x][y] = 1;
            }

            int count = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        bfs(i, j);
                        count++;
                    }
                }
            }

            System.out.println(count);

            t--;
        }
    }

    private static void bfs(int x, int y) {
        Queue<int []> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int curX = q.peek()[0];
            int curY = q.peek()[1];
            q.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = curX + dx[dir];
                int ny = curY + dy[dir];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (map[nx][ny] == 1 && !visited[nx][ny]) {
                        q.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
}


