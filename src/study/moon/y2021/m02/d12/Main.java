package study.moon.y2021.m02.d12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

//https://www.acmicpc.net/problem/16234    [G5]    인구이동
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int L = Integer.parseInt(s[1]);
        int R = Integer.parseInt(s[2]);

        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            s = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }

        Solution solution = new Solution();
        bw.write(solution.solution(N, L, R, arr) + "");
        bw.flush();
        bw.close();
        br.close();
    }
}

class Solution {

    int N;
    int L;
    int R;
    int[][] arr;
    int count;
    int[][] union;
    boolean check;
    int answer = 0;
    Map<Integer,Integer> map = new HashMap<>();

    public int solution(int N, int L, int R, int[][] arr) {
        this.N = N;
        this.L = L;
        this.R = R;
        this.arr = arr;
        open();
        return answer;
    }

    private void open() {
        while (true) {
            union = new int[N][N];
            count = 0;
            check = false;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (union[i][j] == 0) {
                        getUnion(i,j);
                    }
                }
            }
            if (check) {
                answer++;
                move();
            } else {
                break;
            }
        }
    }

    private void getUnion(int n, int m) {
        count++;
        int unionCount = 0;
        int unionSum = 0;
        LinkedList<Place> queue = new LinkedList<>();
        queue.add(new Place(n, m));
        while (!queue.isEmpty()) {
            Place poll = queue.poll();
            if (poll.n < 0 || poll.n >= N || poll.m < 0 || poll.m >= N) {
                continue;
            }
            if (union[poll.n][poll.m]!=0) {
                continue;
            }
            unionSum += arr[poll.n][poll.m];
            union[poll.n][poll.m] = count;
            unionCount++;
            if (poll.n - 1 >= 0
                && Math.abs(arr[poll.n][poll.m]-arr[poll.n-1][poll.m]) >= L
                && Math.abs(arr[poll.n][poll.m]-arr[poll.n-1][poll.m]) <= R
            ) {
                queue.add(new Place(poll.n - 1, poll.m));
                check = true;
            }
            if (poll.n + 1 < N
                && Math.abs(arr[poll.n][poll.m]-arr[poll.n+1][poll.m]) >= L
                && Math.abs(arr[poll.n][poll.m]-arr[poll.n+1][poll.m]) <= R
            ) {
                queue.add(new Place(poll.n + 1, poll.m));
                check = true;
            }
            if (poll.m - 1 >= 0
                && Math.abs(arr[poll.n][poll.m]-arr[poll.n][poll.m-1]) >= L
                && Math.abs(arr[poll.n][poll.m]-arr[poll.n][poll.m-1]) <= R
            ) {
                queue.add(new Place(poll.n, poll.m - 1));
                check = true;
            }
            if (poll.m + 1 < N
                && Math.abs(arr[poll.n][poll.m]-arr[poll.n][poll.m+1]) >= L
                && Math.abs(arr[poll.n][poll.m]-arr[poll.n][poll.m+1]) <= R
            ) {
                queue.add(new Place(poll.n, poll.m + 1));
                check = true;
            }
        }
        int average = unionSum/unionCount;
        map.put(count,average);
    }

    private void move() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = map.get(union[i][j]);
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
