package study.eunwoo.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// [1325 효율적인 해킹] https://www.acmicpc.net/problem/1325
public class B1325 {
    private static ArrayList<Integer> [] arr;
    private static boolean [] visited;
    private static int [] hacking;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        arr = new ArrayList[n+1];
        hacking = new int[n+1];

        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
        }

        for (int i = 1; i <= n; i++) {
            visited = new boolean[n+1];
            bfs(i);
        }

        int max = 0;

        for (int i = 1; i <= n; i++) {
            max = Math.max(max, hacking[i]);
        }

        for (int i = 1; i <= n; i++) {
            if (max == hacking[i]) {
                System.out.print(i + " ");
            }
        }
    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int temp = q.poll();

            for (int i = 0; i < arr[temp].size(); i++) {
                int v = arr[temp].get(i);

                if (!visited[v]) {
                    visited[v] = true;
                    hacking[v]++;
                    q.offer(v);
                }
            }
        }
    }
}
