package study.moon.y2021.m01.d04.t01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

//https://www.acmicpc.net/problem/14502    [G5]    연구소
public class Main {

    static LinkedList<Place> queue = new LinkedList<>();
    static int n;
    static int m;
    static int[] moveX = {-1, 1, 0, 0};
    static int[] moveY = {0, 0, -1, 1};
    static int[][] arr;
    static int COUNT;
    static int ANSWER = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            s = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 2) {
                    queue.offer(new Place(i, j));
                }
                if (arr[i][j] == 0) {
                    COUNT++;
                }
            }
        }
        COUNT-=3;

        //3개 뽑기
        combination(0, getCopy());

        bw.write(ANSWER + "");
        bw.flush();
        bw.close();
    }

    static void combination(int depth, int[][] copy) {
        if (depth == 3) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (copy[i][j] == 2) {
                        queue.offer(new Place(i, j));
                    }
                }
            }
            bfs(copy);
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copy[i][j] == 0) {
                    copy[i][j] = 1;
                    combination(depth + 1, copy);
                    copy[i][j] = 0;
                }
            }
        }
    }

    static int[][] getCopy() {
        int[][] copy = new int[n][m];
        for (int i = 0; i < n; i++) {
            if (m >= 0) {
                System.arraycopy(arr[i], 0, copy[i], 0, m);
            }
        }
        return copy;
    }

    private static void bfs(int[][] copy) {
        int count = COUNT;
        boolean[][] visit = new boolean[n][m];
        while (!queue.isEmpty()) {
            Place poll = queue.poll();
            if (poll.n < 0 || poll.n >= n || poll.m < 0 || poll.m >= m) {
                continue;
            }

            if (copy[poll.n][poll.m] == 1 || visit[poll.n][poll.m]) {
                continue;
            }
            visit[poll.n][poll.m] = true;
            if (copy[poll.n][poll.m]==0) {
                count--;
            }

            for (int i = 0; i < 4; i++) {
                queue.add(new Place(poll.n + moveX[i], poll.m + moveY[i]));
            }
        }
        if (count > ANSWER) {
            ANSWER = count;
        }
    }

}

class Place {

    int n;
    int m;

    public Place(int n, int m) {
        this.n = n;
        this.m = m;
    }
}
