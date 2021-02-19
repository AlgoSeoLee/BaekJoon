package study.eunwoo.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// [1987 알파벳] https://www.acmicpc.net/problem/1987
public class B1987 {
    private static final int [] dx = { -1, 1, 0, 0 }; // 상하좌우
    private static final int [] dy = { 0, 0, -1, 1 };
    private static int r, c;
    private static char [][] map;
    private static final boolean [] visited = new boolean[26];
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] str = br.readLine().split(" ");
        r = Integer.parseInt(str[0]);
        c = Integer.parseInt(str[1]);

        map = new char[r][c];

        for (int i = 0; i < r; i++) {
            String s = br.readLine();

            for (int j = 0; j < c; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        visited[map[0][0] - 'A'] = true;
        dfs(0, 0, 1);

        System.out.println(answer);
    }

    private static void dfs(int y, int x, int count) {
        answer = Math.max(answer, count);

        for (int dir = 0; dir < 4; dir++) {
            int ny = y + dy[dir];
            int nx = x + dx[dir];

            if (nx >= 0 && ny >= 0 && ny < r && nx < c) {
                int k = (int)map[ny][nx] - 'A';

                if (!visited[k]) {
                    visited[k] = true;
                    dfs(ny, nx,count+1);
                    visited[k] = false;
                }
            }
        }

    }
}
