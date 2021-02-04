package study.moon.y2021.m02.d03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//https://www.acmicpc.net/problem/11437    [G3]    LCA
public class Main {

    static ArrayList<Integer>[] adj;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int vertex = Integer.parseInt(br.readLine());
        int edge = vertex - 1;
        adj = new ArrayList[vertex + 1];

        for (int i = 0; i < vertex + 1; i++) {
            adj[i] = new ArrayList<>();
        }
        visit = new boolean[vertex + 1];
        visit[1] = true;

        for (int i = 0; i < edge; i++) {
            String[] s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            if (visit[start]) {
                adj[end].add(start);
                visit[end] = true;
            } else {
                adj[start].add(end);
                visit[start] = true;
            }
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            String[] s = br.readLine().split(" ");
            bw.write(solution(Integer.parseInt(s[0]), Integer.parseInt(s[1])) + "\n");
        }

        bw.flush();
        bw.close();
    }

    private static int solution(int vertex1, int vertex2) {
        List<Integer> path1 = new ArrayList<>();
        List<Integer> path2 = new ArrayList<>();
        path1 = getPath(path1, vertex1);
        path2 = getPath(path2, vertex2);
        path1.retainAll(path2);
        return path1.get(0);
    }

    private static List<Integer> getPath(List<Integer> path, int vertex) {
        path.add(vertex);
        while (!adj[vertex].isEmpty()) {
            path.add(adj[vertex].get(0));
            vertex = adj[vertex].get(0);
        }
        return path;
    }
}
