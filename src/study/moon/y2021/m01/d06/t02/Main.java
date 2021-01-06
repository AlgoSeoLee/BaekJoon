package study.moon.y2021.m01.d06.t02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static int N;
    static int M;
    static int x;
    static int y;
    static int K;
    static int[][] arr;

    static int[] dice = {0, 0, 0, 0, 0, 0, 0};

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        x = Integer.parseInt(s[2]);
        y = Integer.parseInt(s[3]);
        K = Integer.parseInt(s[4]);
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            s = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }
        s = br.readLine().split(" ");
        for (String value : s) {
            moveDice(value);
        }
        bw.flush();
        bw.close();
    }

    private static void print() throws IOException {
        bw.write(dice[1] + "\n");
    }

    private static void copy() {
        if (arr[x][y] == 0) {
            arr[x][y] = dice[6];
        } else {
            dice[6] = arr[x][y];
            arr[x][y] = 0;
        }
    }

    private static void moveDice(String direction) throws IOException {
        int tmp;
        if (direction.equals("1")) {
            if (y + 1 >= M) {
                return;
            }
            y++;
            tmp = dice[3];
            dice[3] = dice[1];
            dice[1] = dice[4];
            dice[4] = dice[6];
            dice[6] = tmp;
        }
        if (direction.equals("2")) {
            if (y - 1 < 0) {
                return;
            }
            y--;
            tmp = dice[4];
            dice[4] = dice[1];
            dice[1] = dice[3];
            dice[3] = dice[6];
            dice[6] = tmp;
        }
        if (direction.equals("3")) {
            if (x - 1 < 0) {
                return;
            }
            x--;
            tmp = dice[2];
            dice[2] = dice[1];
            dice[1] = dice[5];
            dice[5] = dice[6];
            dice[6] = tmp;
        }
        if (direction.equals("4")) {
            if (x + 1 >= N) {
                return;
            }
            x++;
            tmp = dice[6];
            dice[6] = dice[5];
            dice[5] = dice[1];
            dice[1] = dice[2];
            dice[2] = tmp;
        }
        copy();
        print();
    }
}
