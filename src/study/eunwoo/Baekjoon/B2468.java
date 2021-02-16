package study.eunwoo.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [2468 안전 영역] https://www.acmicpc.net/problem/2468
public class B2468 {
    private static final int [] dx = { -1, 1, 0, 0 }; // 상하좌우
    private static final int [] dy = { 0, 0, -1, 1 };
    private static int n;
    private static int [][] map;
    private static boolean [][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visited = new boolean[n][n];

        int max = 0;
        int min = 100;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                max = Math.max(max, map[i][j]);
                min = Math.min(min, map[i][j]);
            }
        }

        int answer = 1;

        for (int height = max; height >= min; height--) {
            int count = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] > height && !visited[i][j]) {
                        dfs(i, j, height);
                        count++;
                    }
                }
            }

            visited = new boolean[n][n];
            answer = Math.max(answer, count);
        }

        System.out.println(answer);
    }

    private static void dfs(int x, int y, int height) {
        visited[x][y] = true;

        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                if (map[nx][ny] > height && !visited[nx][ny]) {
                    dfs(nx, ny, height);
                }
            }
        }
    }

}
