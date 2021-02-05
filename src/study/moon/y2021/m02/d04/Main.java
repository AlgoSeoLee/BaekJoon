package study.moon.y2021.m02.d04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

//https://www.acmicpc.net/problem/13460    [G2]    구슬탈출2
public class Main {

    static LinkedList<Data> queue;
    static char[][] arr;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        //given
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        arr = new char[N][M];
        queue = new LinkedList<>();
        int bn = 0;
        int bm = 0;
        int rn = 0;
        int rm = 0;
        for (int i = 0; i < N; i++) {
            String s1 = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = s1.charAt(j);
                if (arr[i][j] == 'R') {
                    rn = i;
                    rm = j;
                    arr[i][j] = '.';
                }
                if (arr[i][j] == 'B') {
                    bn = i;
                    bm = j;
                    arr[i][j] = '.';
                }
            }
        }
        queue.add(new Data(bn, bm, rn, rm, 1));

        //when
        bfs();

    }

    private static void bfs() throws IOException {
        while (!queue.isEmpty()) {
            Data poll = queue.poll();
            Data moveUp = moveUp(poll);
            if (moveUp != null) {
                queue.add(moveUp);
            }
            Data moveDown = moveDown(poll);
            if (moveDown != null) {
                queue.add(moveDown);
            }
            Data moveLeft = moveLeft(poll);
            if (moveLeft != null) {
                queue.add(moveLeft);
            }
            Data moveRight = moveRight(poll);
            if (moveRight != null) {
                queue.add(moveRight);
            }
        }
        bw.write("-1");
        bw.flush();
    }

    private static Data moveUp(Data data) throws IOException {
        if (data.count > 10) {
            return null;
        }
        boolean isEnd = false;
        int bn = data.blueN;
        int bm = data.blueM;
        int rn = data.redN;
        int rm = data.redM;
        if (isBlueFirst(data, 0)) {
            while ((arr[bn - 1][bm] == '.' || arr[bn - 1][bm] == 'O')) {
                if (arr[bn - 1][bm] == 'O') {
                    return null;
                }
                bn--;
            }
            while (((arr[rn - 1][rm] == '.' || arr[rn - 1][rm] == 'O') && !(rn - 1 == bn && rm==bm))) {
                if (arr[rn - 1][rm] == 'O') {
                    isEnd = true;
                    rn = 0;
                    break;
                }
                rn--;
            }
        } else {
            while ((arr[rn - 1][rm] == '.' || arr[rn - 1][rm] == 'O')) {
                if (arr[rn - 1][rm] == 'O') {
                    isEnd = true;
                    rn = 0;
                    break;
                }
                rn--;
            }
            while (((arr[bn - 1][bm] == '.' || arr[bn - 1][bm] == 'O') && !(bn - 1 == rn && bm==rm))) {
                if (arr[bn - 1][bm] == 'O') {
                    return null;
                }
                bn--;
            }
        }
        if (isEnd) {
            bw.write(data.count+"");
            bw.flush();
            System.exit(0);
        }
        return new Data(bn, bm, rn, rm, data.count + 1);
    }

    private static Data moveDown(Data data) throws IOException {
        if (data.count > 10) {
            return null;
        }
        boolean isEnd = false;
        int bn = data.blueN;
        int bm = data.blueM;
        int rn = data.redN;
        int rm = data.redM;
        if (isBlueFirst(data, 2)) {
            while ((arr[bn + 1][bm] == '.' || arr[bn + 1][bm] == 'O')) {
                if (arr[bn + 1][bm] == 'O') {
                    return null;
                }
                bn++;
            }
            while ((arr[rn + 1][rm] == '.' || arr[rn + 1][rm] == 'O') && !(rn + 1 == bn && rm == bm)) {
                if (arr[rn + 1][rm] == 'O') {
                    isEnd = true;
                    rn = 0;
                    break;
                }
                rn++;
            }
        } else {
            while ((arr[rn + 1][rm] == '.' || arr[rn + 1][rm] == 'O')) {
                if (arr[rn + 1][rm] == 'O') {
                    isEnd = true;
                    rn = 0;
                    break;
                }
                rn++;
            }
            while ((arr[bn + 1][bm] == '.' || arr[bn + 1][bm] == 'O') && !(bn + 1 == rn && bm==rm)) {
                if (arr[bn + 1][bm] == 'O') {
                    return null;
                }
                bn++;
            }
        }
        if (isEnd) {
            bw.write(data.count+"");
            bw.flush();
            System.exit(0);
        }
        return new Data(bn, bm, rn, rm, data.count + 1);
    }

    private static Data moveRight(Data data) throws IOException {
        if (data.count > 10) {
            return null;
        }
        boolean isEnd = false;
        int bn = data.blueN;
        int bm = data.blueM;
        int rn = data.redN;
        int rm = data.redM;
        if (isBlueFirst(data, 1)) {
            while ((arr[bn][bm + 1] == '.' || arr[bn][bm + 1] == 'O')) {
                if (arr[bn][bm + 1] == 'O') {
                    return null;
                }
                bm++;
            }
            while ((arr[rn][rm + 1] == '.' || arr[rn][rm + 1] == 'O') && !(rm + 1 == bm && rn==bn)) {
                if (arr[rn][rm + 1] == 'O') {
                    isEnd = true;
                    rm = 0;
                    break;
                }
                rm++;
            }
        } else {
            while ((arr[rn][rm + 1] == '.' || arr[rn][rm + 1] == 'O')) {
                if (arr[rn][rm + 1] == 'O') {
                    isEnd = true;
                    rm = 0;
                    break;
                }
                rm++;
            }
            while ((arr[bn][bm + 1] == '.' || arr[bn][bm + 1] == 'O') && !(bm + 1 == rm && bn==rn)) {
                if (arr[bn][bm + 1] == 'O') {
                    return null;
                }
                bm++;
            }
        }
        if (isEnd) {
            bw.write(data.count+"");
            bw.flush();
            System.exit(0);
        }
        return new Data(bn, bm, rn, rm, data.count + 1);
    }

    private static Data moveLeft(Data data) throws IOException {
        if (data.count > 10) {
            return null;
        }
        boolean isEnd = false;
        int bn = data.blueN;
        int bm = data.blueM;
        int rn = data.redN;
        int rm = data.redM;
        if (isBlueFirst(data, 3)) {
            while ((arr[bn][bm - 1] == '.' || arr[bn][bm - 1] == 'O')) {
                if (arr[bn][bm - 1] == 'O') {
                    return null;
                }
                bm--;
            }
            while ((arr[rn][rm - 1] == '.' || arr[rn][rm - 1] == 'O') && !(rm - 1 == bm && rn==bn)) {
                if (arr[rn][rm - 1] == 'O') {
                    isEnd = true;
                    rm = 0;
                    break;
                }
                rm--;
            }
        } else {
            while ((arr[rn][rm - 1] == '.' || arr[rn][rm - 1] == 'O')) {
                if (arr[rn][rm - 1] == 'O') {
                    isEnd = true;
                    rm =0;
                    break;
                }
                rm--;
            }
            while ((arr[bn][bm - 1] == '.' || arr[bn][bm - 1] == 'O') && !(bm - 1 == rm && bn==rn)) {
                if (arr[bn][bm - 1] == 'O') {
                    return null;
                }
                bm--;
            }
        }
        if (isEnd) {
            bw.write(data.count+"");
            bw.flush();
            System.exit(0);
        }
        return new Data(bn, bm, rn, rm, data.count + 1);
    }

    private static boolean isBlueFirst(Data data, int direction) {
        if (direction == 0) {
            return data.blueN < data.redN;
        } else if (direction == 1) {
            return data.blueM > data.redM;
        } else if (direction == 2) {
            return data.blueN > data.redN;
        } else {
            return data.blueM < data.redM;
        }
    }
}

class Data {

    int blueN;
    int blueM;
    int redN;
    int redM;
    int count;

    public Data(int blueN, int blueM, int redN, int redM, int count) {
        this.blueN = blueN;
        this.blueM = blueM;
        this.redN = redN;
        this.redM = redM;
        this.count = count;
    }
}
