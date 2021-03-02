package study.moon.y2021.m03.d01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

//https://www.acmicpc.net/problem/16724    피리부는 사나이    [G2]
public class Main {

    static char[][] arr;
    static int[][] visit;
    static LinkedList<Place> queue = new LinkedList<>();
    static int count = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        arr = new char[n][m];
        visit = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s1 = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = s1.charAt(j);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visit[i][j] == 0) {
                    dfs(i, j);
                }
            }
        }
        bw.write(count-1+"");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int n, int m) {
        if (visit[n][m] != 0) {
            //순환을 만나면
            if (visit[n][m] == count) {
                queue.clear();
                count++;
                return;
            }
            //비순환이면
            if (visit[n][m] != count) {
                while (!queue.isEmpty()) {
                    Place poll = queue.poll();
                    visit[poll.n][poll.m] = visit[n][m];
                }
                return;
            }
        }
        queue.add(new Place(n,m));
        visit[n][m] = count;
        if (arr[n][m] == 'D') {
            dfs(n + 1, m);
        } else if (arr[n][m] == 'U') {
            dfs(n - 1, m);
        } else if (arr[n][m] == 'L') {
            dfs(n, m - 1);
        } else {
            dfs(n, m + 1);
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
