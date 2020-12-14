package study.moon.d201212.t03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
//https://www.acmicpc.net/problem/7569
public class Main {

    static int[] moveX = {-1, 1, 0, 0, 0, 0};
    static int[] moveY = {0, 0, -1, 1, 0, 0};
    static int[] moveZ = {0, 0, 0, 0, -1, 1};

    static int m;
    static int n;
    static int h;
    static LinkedList<Place> queue;
    static int[][][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        m = Integer.parseInt(s[0]);
        n = Integer.parseInt(s[1]);
        h = Integer.parseInt(s[2]);

        //데이터 삽입
        arr = new int[h][n][m];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                s = br.readLine().split(" ");
                for (int k = 0; k < m; k++) {
                    arr[i][j][k] = Integer.parseInt(s[k]);
                }
            }
        }

        queue = new LinkedList<>();

        //데이터 순회
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (arr[i][j][k] == 1) {
                        queue.offer(new Place(k, j, i, 0));
                    }
                }
            }
        }

        int answer = bfs();

        if (!isEnd()) {
            bw.write("-1");
        } else {
            bw.write(answer+"");
        }
        bw.flush();
        bw.close();
    }

    private static boolean isEnd() {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (arr[i][j][k] == 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static int bfs() {
        int answer = 0;
        while (!queue.isEmpty()) {
            Place poll = queue.poll();
            if (poll.x < 0 || poll.x >= m || poll.y < 0 || poll.y >= n || poll.z < 0
                || poll.z >= h) {
                continue;
            }
            if (arr[poll.z][poll.y][poll.x] == -1 || arr[poll.z][poll.y][poll.x] == 2) {
                continue;
            }
            if (poll.time > answer) {
                answer = poll.time;
            }
            arr[poll.z][poll.y][poll.x] = 2;

            for (int i = 0; i < 6; i++) {
                queue.offer(new Place(poll.x + moveX[i], poll.y + moveY[i], poll.z + moveZ[i],
                    poll.time + 1));
            }
        }
        return answer;
    }

}

class Place {

    int x;
    int y;
    int z;
    int time;

    public Place(int x, int y, int z, int time) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.time = time;
    }
}
