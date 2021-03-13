package study.moon.y2021.m03.d10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class Main {

    static LinkedList<Place> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        int m = Integer.parseInt(s[0]);
        int n = Integer.parseInt(s[1]);
        int k = Integer.parseInt(s[2]);

        int[][] arr = new int[m][n];

        for (int i = 0; i < k; i++) {
            String[] s1 = br.readLine().split(" ");
            int n1 = Integer.parseInt(s1[0]);
            int m1 = Integer.parseInt(s1[1]);
            int n2 = Integer.parseInt(s1[2]);
            int m2 = Integer.parseInt(s1[3]);
            for (int l = m1; l < m2; l++) {
                for (int o = n1; o < n2; o++) {
                    arr[l][o] = 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0) {
                    queue.offer(new Place(i,j));
                    bfs(i,j);
                }
            }
        }

    }
    private static int bfs(int m, int n) {
        while(!queue.isEmpty()) {
            Place poll = queue.poll();

        }
        return 0;
    }
}

class Place {
    int m;
    int n;

    public Place(int m, int n) {
        this.m = m;
        this.n = n;
    }
}
