package study.eunwoo.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// [2583 영역 구하기] https://www.acmicpc.net/problem/2583
public class B2583 {
    private static final int [] dx = { -1, 1, 0, 0 }; // 상하좌우
    private static final int [] dy = { 0, 0, -1, 1 };
    private static int m,n;
    private static int [][] map;
    private static boolean [][] visited;
    private static int count = 0;
    private static final int [] area = new int[100*100];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] str = br.readLine().split(" ");
        m = Integer.parseInt(str[0]);
        n = Integer.parseInt(str[1]);
        int k = Integer.parseInt(str[2]);

        map = new int[m][n];
        visited = new boolean[m][n];

        int x1, y1, x2, y2;

        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            for (int y = y1; y < y2; y++) {
                for (int x = x1; x < x2; x++) {
                    map[y][x] = -1;
                }
            }
        }

        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                if (map[y][x] == 0 && !visited[y][x]) {
                    bfs(y, x);
                    count++;
                }
            }
        }

        Arrays.sort(area);

        System.out.println(count);
        for (int i: area) {
            if (i != 0) {
                System.out.print(i + " ");
            }
        }

    }

    private static void bfs(int y, int x) {
        Queue<int []> q = new LinkedList<>();
        q.offer(new int[]{y, x});
        visited[y][x] = true;
        area[count]++;

        while (!q.isEmpty()) {
            int curY = q.peek()[0];
            int curX = q.peek()[1];
            q.poll();

            for (int dir = 0; dir < 4; dir++) {
                int ny = curY + dy[dir];
                int nx = curX + dx[dir];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (map[ny][nx] == 0 && !visited[ny][nx]) {
                        q.offer(new int[]{ny, nx});
                        visited[ny][nx] = true;
                        area[count]++;
                    }
                }
            }
        }
    }
}
