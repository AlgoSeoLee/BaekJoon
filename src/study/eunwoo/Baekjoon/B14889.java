package study.eunwoo.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [14889 스타트와 링크] https://www.acmicpc.net/problem/14889
public class B14889 {
    private static int n;
    private static int [][] map;
    private static boolean [] visited;
    private static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,0);

        System.out.println(answer);
    }

    private static void dfs(int index, int count) {
        if (n / 2 == count) {
            answer = Math.min(answer, getScore());
            return;
        }

        for (int i = index; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i+1, count+1);
                visited[i] = false;
            }
        }
    }
    
    private static int getScore() {
        int startScore = 0;
        int linkScore = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i] && visited[j]) {
                    startScore += map[i][j];
                } else if (!visited[i] && !visited[j]) {
                    linkScore += map[i][j];
                }
            }
        }

        return Math.abs(startScore - linkScore);
    }
}
