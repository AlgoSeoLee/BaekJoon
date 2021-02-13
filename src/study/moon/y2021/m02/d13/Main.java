package study.moon.y2021.m02.d13;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

//https://www.acmicpc.net/problem/2468    [S1]    안전영역
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }

        Solution solution = new Solution();
        bw.write(solution.solution(N, arr) + "");
        bw.flush();
        bw.close();
        br.close();
    }
}

class Solution {
    boolean[][] map;
    int[][] arr;
    int N;
    int safeZone = 0;
    LinkedList<Place> queue = new LinkedList<>();

    int[] moveN = {-1,1,0,0};
    int[] moveM = {0,0,-1,1};
    int answer = 0;

    public int solution(int N, int[][] arr) {
        this.arr = arr;
        this.N = N;
        for (int i = 0; i <= 100; i++) {
            safeZone = 0;
            rain(i);
            getSafeZone();
            if(safeZone > answer) {
                answer = safeZone;
            }
        }
        return answer;
    }

    private void getSafeZone() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!map[i][j]) {
                    bfs(i, j);
                }
            }
        }
    }

    private void bfs(int i, int j) {
        queue.add(new Place(i, j));
        safeZone++;
        while (!queue.isEmpty()) {
            Place poll = queue.poll();
            if (poll.n < 0 || poll.n >= N || poll.m < 0 || poll.m >= N) {
                continue;
            }
            if (map[poll.n][poll.m]) {
                continue;
            }
            map[poll.n][poll.m] = true;

            for (int k = 0; k < 4; k++) {
                queue.add(new Place(poll.n+moveN[k],poll.m+moveM[k]));
            }
        }
    }

    private void rain(int height) {
        map = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] <= height) {
                    map[i][j] = true;
                }
            }
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
