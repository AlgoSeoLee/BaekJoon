package study.eunwoo.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// [14502 연구소] https://www.acmicpc.net/problem/14502
public class B14502 {
    private static final int [] dx = { -1, 1, 0, 0 }; // 상하좌우
    private static final int [] dy = { 0, 0, -1, 1 };
    private static int n, m;
    private static int [][] map;
    private static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);

        int[][] inputMap = new int[n][m];
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                inputMap[i][j] = map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (inputMap[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(1);
                    map[i][j] = 0;
                }
            }
        }

        System.out.println(answer);
    }

    private static void dfs(int count) {
        if (count == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(count+1);
                    map[i][j] = 0;
                }
            }
        }
    }

    private static void bfs() {
        int [][] resultMap = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                resultMap[i][j] = map[i][j];
            }
        }

        Queue<int []> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (resultMap[i][j] == 2)
                    q.offer(new int[]{i, j});
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
                    if (resultMap[nx][ny] == 0) {
                        resultMap[nx][ny] = 2;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }

        countSafeArea(resultMap);
    }

    private static void countSafeArea(int [][] resultMap) {
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (resultMap[i][j] == 0)
                    count++;
            }
        }

        answer = Math.max(count, answer);
    }
}


