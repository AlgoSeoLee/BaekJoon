package study.moon.y2020.m12.d201226.t01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class Main {

    static int min = Integer.MAX_VALUE;
    static int n;
    static int m;
    static int[][] arr;
    static int[] moveX = {-1, 1, 0, 0};
    static int[] moveY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] split = br.readLine().split(" ");
        n = Integer.parseInt(split[0]);
        m = Integer.parseInt(split[1]);

        arr = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            String s = br.readLine();
            for (int j = 1; j <= m; j++) {
                int numericValue = Character.getNumericValue(s.charAt(j - 1));
                if (numericValue == 1) {
                    arr[i][j] = -1;
                }
            }
        }

        bfs();

        if (min == Integer.MAX_VALUE) {
            bw.write("-1");
        } else {
            bw.write(min + "");
        }
        bw.flush();
        bw.close();

    }

    private static void bfs() {
        LinkedList<Place> queue = new LinkedList<>();

        int result = Integer.MAX_VALUE;
        queue.add(new Place(1, 1, 1, 0));
        while (!queue.isEmpty()) {
            Place poll = queue.poll();
            if (poll.m < 1 || poll.m > m || poll.n < 1 || poll.n > n) {
                continue;
            }
            if (arr[poll.n][poll.m] == -1) {
                if (poll.block >= 1) {
                    continue;
                } else {
                    poll.block++;
                }
            }
            if (arr[poll.n][poll.m] >= 0) {
                if (poll.block>=1) {
                    continue;
                } else {
                    if (arr[poll.n][poll.m] <= poll.length) {
                        continue;
                    }
                }
            }
            if (poll.n == n && poll.m == m) {
                result = poll.length;
                break;
            }
            arr[poll.n][poll.m] = poll.length;

            for (int i = 0; i < 4; i++) {
                queue.add(
                    new Place(poll.n + moveX[i], poll.m + moveY[i], poll.length + 1, poll.block));
            }
        }
        if (result < min) {
            min = result;
        }
    }
}

class Place {

    int n;
    int m;
    int length;
    int block;

    public Place(int n, int m, int length, int block) {
        this.n = n;
        this.m = m;
        this.length = length;
        this.block = block;
    }
}
