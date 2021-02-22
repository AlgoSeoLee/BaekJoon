package study.eunwoo.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// [2206 벽 부수고 이동하기] https://www.acmicpc.net/problem/2206
public class B2206 {
    private static final int[] dx = {-1, 1, 0, 0}; // 상하좌우
    private static final int[] dy = {0, 0, -1, 1};
    private static int[][] map, visited;
    private static int n, m;
    private static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);

        map = new int[n][m];
        visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();

            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j) - '0';
                visited[i][j] = Integer.MAX_VALUE;
            }
        }

        bfs();

        if (answer == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(answer);
    }

    private static void bfs() {
        Queue<Place> q = new LinkedList<>();
        q.offer(new Place(0, 0, 1, 0));
        visited[0][0] = 0;

        while (!q.isEmpty()) {
            Place p = q.poll();

            if (p.y == n-1 && p.x == m-1) {
                answer = p.dist;
                break;
            }

            for (int dir = 0; dir < 4; dir++) {
                int ny = p.y + dy[dir];
                int nx = p.x + dx[dir];

                if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue;

                if (visited[ny][nx] <= p.count) continue;

                if (map[ny][nx] == 0) {
                    visited[ny][nx] = p.count;
                    q.offer(new Place(ny, nx, p.dist + 1, p.count));

                } else {
                    if (p.count == 0) {
                        visited[ny][nx] = p.count + 1;
                        q.offer(new Place(ny, nx, p.dist + 1, p.count + 1));
                    }
                }

            }
        }
    }

    private static class Place {
        int y;
        int x;
        int dist;
        int count;

        public Place(int y, int x, int dist, int count) {
            this.y = y;
            this.x = x;
            this.dist = dist;
            this.count = count;
        }
    }
}

