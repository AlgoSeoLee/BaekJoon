package study.moon.y2021.m01.d20;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//https://www.acmicpc.net/problem/9466    [G4]    텀 프로젝트
public class Main {

    static int[] arr;
    static boolean[] visit;
    static boolean[] done;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            cnt = 0;
            arr = new int[n + 1];
            visit = new boolean[n + 1];
            done = new boolean[n + 1];
            String[] s = br.readLine().split(" ");
            for (int j = 1; j <= n; j++) {
                arr[j] = Integer.parseInt(s[j - 1]);
            }
            for (int j = 1; j <= n; j++) {
                if (!done[j]) {
                    dfs(j);
                }
            }
            bw.write(n - cnt + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    private static void dfs(int v) {
        if (visit[v]) {
            done[v] = true;
            cnt++;
        } else {
            visit[v] = true;
        }

        if (!done[arr[v]]) {
            dfs(arr[v]);
        }
        visit[v] = false;
        done[v] = true;
    }
}
