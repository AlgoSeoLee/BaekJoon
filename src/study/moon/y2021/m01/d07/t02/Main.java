package study.moon.y2021.m01.d07.t02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

//https://www.acmicpc.net/problem/17144    [G5]    미세먼지 안녕!    <발표>
public class Main {

    static int R;
    static int C;
    static int T;
    static int[][] arr;
    static LinkedList<Place> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        R = Integer.parseInt(s[0]);
        C = Integer.parseInt(s[1]);
        T = Integer.parseInt(s[2]);
        arr = new int[R + 1][C + 1];
        for (int i = 1; i <= R; i++) {
            s = br.readLine().split(" ");
            for (int j = 1; j <= C; j++) {
                arr[i][j] = Integer.parseInt(s[j - 1]);
            }
        }

        for (int k = 0; k < T; k++) {
            for (int i = 1; i <= R; i++) {
                for (int j = 1; j <= C; j++) {
                    if (arr[i][j] != 0 && arr[i][j] != -1) {
                        queue.add(new Place(i, j, arr[i][j]));
                        arr[i][j] = 0;
                    }
                }
            }
            bfs();
        }

        int answer = 2;
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                answer += arr[i][j];
            }
        }
        bw.write(answer+"");
        bw.flush();
        bw.close();
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            Place poll = queue.poll();
            if (poll.n <= 0 || poll.n > R || poll.m <= 0 || poll.m > C) {
                continue;
            }

            int count = 0;
            if (poll.n + 1 <= R && arr[poll.n + 1][poll.m] != -1) {
                arr[poll.n + 1][poll.m] += poll.dust / 5;
                count++;
            }
            if (poll.n - 1 > 0 && arr[poll.n - 1][poll.m] != -1) {
                arr[poll.n - 1][poll.m] += poll.dust / 5;
                count++;
            }
            if (poll.m + 1 <= C && arr[poll.n][poll.m + 1] != -1) {
                arr[poll.n][poll.m + 1] += poll.dust / 5;
                count++;
            }
            if (poll.m - 1 > 0 && arr[poll.n][poll.m - 1] != -1) {
                arr[poll.n][poll.m - 1] += poll.dust / 5;
                count++;
            }

            arr[poll.n][poll.m] += poll.dust - (poll.dust / 5) * count;
        }

        int[] cleaner = new int[2];
        for (int i = 1; i <= R; i++) {
            if (arr[i][1] == -1) {
                cleaner[0] = i;
                cleaner[1] = i + 1;
                break;
            }
        }
        for (int i = cleaner[0] - 1; i > 0; i--) {
            arr[i][1] = arr[i - 1][1];
        }
        for (int i = 1; i < C; i++) {
            arr[1][i] = arr[1][i + 1];
        }
        for (int i = 1; i <= cleaner[0] - 1; i++) {
            arr[i][C] = arr[i + 1][C];
        }
        for (int i = C; i > 2; i--) {
            arr[cleaner[0]][i] = arr[cleaner[0]][i-1];
        }
        arr[cleaner[0]][2] = 0;

        for (int i = cleaner[1]+1; i < R; i++) {
            arr[i][1] = arr[i+1][1];
        }
        for (int i = 1; i < C; i++) {
            arr[R][i] = arr[R][i+1];
        }
        for (int i = R; i > cleaner[1]; i--) {
            arr[i][C] = arr[i-1][C];
        }
        for (int i = C; i > 2; i--) {
            arr[cleaner[1]][i] = arr[cleaner[1]][i-1];
        }
        arr[cleaner[1]][2] = 0;
    }
}

class Place {

    int n;
    int m;
    int dust;

    public Place(int n, int m, int dust) {
        this.n = n;
        this.m = m;
        this.dust = dust;
    }
}
