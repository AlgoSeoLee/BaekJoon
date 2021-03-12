package study.moon.y2021.m03.d12;

import java.io.*;
import java.util.Arrays;

//https://www.acmicpc.net/problem/2098    [G1]    외판원순회
public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final int INF = 16 * 1_000_000;
    static int vertex;
    static int[][] graph;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        vertex = Integer.parseInt(br.readLine());
        graph = new int[vertex][vertex];
        dp = new int[vertex][(1 << vertex) - 1];

        for (int i = 0; i < vertex; i++) {
            Arrays.fill(dp[i], INF);
        }

        for (int i = 0; i < vertex; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < vertex; j++) {
                int value = Integer.parseInt(s[j]);
                graph[i][j] = value;
            }
        }

        bw.write(tsp(0, 1) + "\n");

        br.close();
        bw.close();
    }

    private static int tsp(int node, int visit) {
        // 모든 지점을 방문한 경우
        if (visit == (1 << vertex) - 1) {
            if (graph[node][0] == 0) {
                return INF;
            }
            return graph[node][0];
        }

        // 이미 계산 했던 경우
        if (dp[node][visit] != INF) {
            return dp[node][visit];
        }

        for (int i = 0; i < vertex; i++) {
            int next = visit | (1 << i);
            // i번 노드에 대해서 길이 없거나 방문한 경우
            if (graph[node][i] == 0 || (visit & (1 << i)) != 0) {
                continue;
            }

            dp[node][visit] = Math.min(dp[node][visit], tsp(i, next) + graph[node][i]);
        }

        return dp[node][visit];
    }
}
