package study.eunwoo.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// [7569 토마토] https://www.acmicpc.net/problem/7569
public class B7569 {
    private static final int[] dx = {0, 0, 0, 0, 1, -1};
    private static final int[] dy = {-1, 0, 1, 0, 0, 0};
    private static final int[] dz = {0, 1, 0, -1, 0, 0};
    private static int m, n, f;
    private static int[][][] map;
    private static final Queue<Point> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        f = Integer.parseInt(st.nextToken());

        map = new int[f][n][m];

        for(int i = 0; i < f; i++){
            for(int j = 0; j < n; j++){
                st = new StringTokenizer(br.readLine());

                for(int k = 0; k < m; k++){
                    map[i][j][k] = Integer.parseInt(st.nextToken());

                    if(map[i][j][k] == 1) {
                        queue.add(new Point(i, j, k));
                    }
                }
            }
        }

        bfs();
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            Point point = queue.poll();

            int curX = point.x;
            int curY = point.y;
            int curZ = point.z;

            for (int dir = 0; dir < 6; dir++) {
                int nx = curX + dx[dir];
                int ny = curY + dy[dir];
                int nz = curZ + dz[dir];

                if (nx >= 0 && ny >= 0 && nz >=0 && nx < f && ny < n && nz < m) {
                    if (map[nx][ny][nz] == 0) {
                        queue.add(new Point(nx, ny, nz));
                        map[nx][ny][nz] = map[curX][curY][curZ] + 1;
                    }
                }
            }
        }

        maxValue();
    }

    private static void maxValue() {
        int max = 0;

        for (int k = 0; k < f; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[k][i][j] == 0) {
                        System.out.println(-1);
                        return;
                    }

                    max = Math.max(max, map[k][i][j]);
                }
            }
        }

        System.out.println(max-1);
    }

    private static class Point {
        int x; // 면
        int y; // 세로
        int z; // 가로

        public Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
