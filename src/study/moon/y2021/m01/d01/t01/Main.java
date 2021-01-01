package study.moon.y2021.m01.d01.t01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

//https://www.acmicpc.net/problem/11725    [s2]    트리의 부모찾기
public class Main {
    static boolean[] visit;
    static int n;
    static ArrayList<Integer>[] adj;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());

        visit = new boolean[n+1];
        adj = new ArrayList[n+1];
        answer = new int[n+1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            String[] s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            adj[start].add(end);
            adj[end].add(start);
        }

        int childCountOfNode = adj[1].size();

        for (int i = 0; i < childCountOfNode; i++) {
            Integer child = adj[1].get(i);
            dfs(1,child);
        }

        for (int i = 2; i <= n; i++) {
            bw.write(answer[i]+"\n");
        }

        bw.flush();
        bw.close();
    }

    private static void dfs(int parent, int child) {
        if (visit[child]) {
            return;
        }
        visit[child] = true;
        answer[child] = parent;

        for (int i = 0; i < adj[child].size(); i++) {
            dfs(child,adj[child].get(i));
        }
    }

}
