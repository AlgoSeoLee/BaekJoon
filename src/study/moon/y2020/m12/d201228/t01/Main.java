package study.moon.y2020.m12.d201228.t01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[][] arr;
    static int[] moveX={-1,1,0,0};
    static int[] moveY={0,0,-1,1};
    static int n;
    static int m;
    static int total = 0;
    static int answer = 0;
    static Queue<Place> queue = new LinkedList<>();
    static Queue<Place> check = new LinkedList<>();

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
                if (arr[i][j]==1) {
                    total++;
                }
            }
        }
        while(total>0) {
            setOuterAir(0,0);
            checkMeltCheese();
            melt();
            answer++;
        }
        System.out.println(answer);

    }

    private static void setOuterAir(int x, int y) {
        queue.offer(new Place(x, y));
        while (!queue.isEmpty()) {
            Place poll = queue.poll();
            if (poll.n < 0 || poll.n >= n || poll.m < 0 || poll.m >= m) {
                continue;
            }
            if (arr[poll.n][poll.m] == 1 || arr[poll.n][poll.m] == -1) {
                continue;
            }
            arr[poll.n][poll.m] = -1;
            for (int i = 0; i < 4; i++) {
                queue.add(new Place(poll.n+moveX[i],poll.m+moveY[i]));
            }
        }
    }

    private static void checkMeltCheese() {
        queue.offer(new Place(1, 1));
        boolean[][] visit = new boolean[n][m];
        while (!queue.isEmpty()) {
            Place poll = queue.poll();
            int count=0;
            if (poll.n < 1 || poll.n >= n-1 || poll.m < 1 || poll.m >= m-1) {
                continue;
            }
            if (visit[poll.n][poll.m]) {
                continue;
            }
            visit[poll.n][poll.m] = true;

            for (int i = 0; i < 4; i++) {
                if (arr[poll.n+moveX[i]][poll.m+moveY[i]]==-1 && arr[poll.n][poll.m]==1) {
                    count++;
                }
            }
            if (count>=2) {
                check.add(new Place(poll.n,poll.m));
            }

            for (int i = 0; i < 4; i++) {
                queue.add(new Place(poll.n+moveX[i],poll.m+moveY[i]));
            }
        }
    }

    private static void melt() {
        while(!check.isEmpty()) {
            Place poll = check.poll();
            arr[poll.n][poll.m] = 0;
            setOuterAir(poll.n,poll.m);
            total--;
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

    @Override
    public String toString() {
        return "Place{" +
            "n=" + n +
            ", m=" + m +
            '}';
    }
}
