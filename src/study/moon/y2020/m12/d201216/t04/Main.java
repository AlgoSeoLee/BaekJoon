package study.moon.y2020.m12.d201216.t04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
//https://www.acmicpc.net/problem/11403
public class Main {

    static int n;
    static int[][] arr;

    static int[][] answer;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        answer = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (hasPath(i, j)) {
                    answer[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                bw.write(answer[i][j] + " ");
            }
            bw.write(answer[i][n - 1] + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static boolean hasPath(int start, int end) {
        boolean[] visit = new boolean[n];
        int count = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            if (poll == end) {
                if (count > 0) {
                    return true;
                }
            }
            if (visit[poll]) {
                continue;
            }
            visit[poll] = true;
            count++;

            for (int i = 0; i < n; i++) {
                if (arr[poll][i] == 1) {
                    queue.add(i);
                }
            }
        }
        return false;
    }

}
