package study.moon.y2020.m12.d201209.t01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

//https://www.acmicpc.net/problem/1012
public class Main {

    static int[] moveX = {-1, 1, 0, 0};
    static int[] moveY = {0, 0, -1, 1};
    static LinkedList<Place> queue;
    static int n;
    static int m;
    static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        queue = new LinkedList<>();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            //초기화
            String[] split = br.readLine().split(" ");
            int answer = 0;

            m = Integer.parseInt(split[0]);
            n = Integer.parseInt(split[1]);
            k = Integer.parseInt(split[2]);

            int[][] arr = new int[n][m];

            for (int j = 0; j < k; j++) {
                String[] split1 = br.readLine().split(" ");
                arr[Integer.parseInt(split1[1])][Integer.parseInt(split1[0])] = 1;
            }

            //로직
            for (int a = 0; a < n; a++) {
                for (int b = 0; b < m; b++) {
                    if (arr[a][b] == 1) {
                        queue.offer(new Place(a, b));
                        bfs(arr);
                        answer++;
                    }
                }
            }
            bw.write(answer + "\n");
        }
        bw.flush();
        bw.close();

    }

    private static void bfs(int[][] arr) {
        while (!queue.isEmpty()) {
            Place poll = queue.poll();
            if (poll.x < 0 || poll.y < 0 || poll.x >= n || poll.y >= m) {
                continue;
            }
            if (arr[poll.x][poll.y] == 0 || arr[poll.x][poll.y] == 2) {
                continue;
            }
            arr[poll.x][poll.y] = 2;

            for (int i = 0; i < 4; i++) {
                queue.offer(new Place(poll.x + moveX[i], poll.y + moveY[i]));
            }
        }
    }

}

class Place {

    int x;
    int y;

    public Place(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
