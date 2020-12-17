package study.moon.d201217.t02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

    static ArrayList<Integer>[] adj;
    static boolean[] visit;

    static LinkedList<Integer> queue = new LinkedList<>();
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        int vertex = Integer.parseInt(s[0]);
        int edge = Integer.parseInt(s[1]);
        adj = new ArrayList[vertex+1];

        for (int i = 0; i < vertex+1; i++) {
            adj[i] = new ArrayList<>();
        }
        visit = new boolean[vertex+1];

        for (int i = 0; i < edge; i++) {
            String[] s1 = br.readLine().split(" ");
            int start = Integer.parseInt(s1[0]);
            int end = Integer.parseInt(s1[1]);
            adj[start].add(end);
            adj[end].add(start);
        }

        for (int i = 1; i <= vertex; i++) {
            if (!visit[i]) {
                queue.offer(i);
                bfs();
                answer++;
            }
        }
        bw.write(answer+"");
        bw.flush();
        bw.close();
    }

    private static void bfs() {
        while(!queue.isEmpty()) {
            int poll = queue.poll();

            if (visit[poll]) {
                continue;
            }

            visit[poll] = true;

            queue.addAll(adj[poll]);
        }
    }
}
