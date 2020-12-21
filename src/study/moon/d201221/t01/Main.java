package study.moon.d201221.t01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//https://www.acmicpc.net/problem/1167
public class Main {

    static int n;
    static List<Data>[] adj;
    static int result;
    static int[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        adj = new ArrayList[n + 1];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 1; i <= n; i++) {
            String[] split = br.readLine().split(" ");
            int vertex = Integer.parseInt(split[0]);
            for (int j = 1; ; j += 2) {
                if (split[j].equals("-1")) {
                    break;
                }
                adj[vertex]
                    .add(new Data(Integer.parseInt(split[j]), Integer.parseInt(split[j + 1])));
            }
        }
        getLongestDistanceFrom(1);
        int distance;
        int target = getFarthermostVertex(1);
        distance = getLongestDistanceFrom(target);
        bw.write(distance+"");
        bw.flush();
        bw.close();
    }

    private static int getLongestDistanceFrom(int vertex) {
        result = Integer.MIN_VALUE;
        visit = new int[n + 1];
        Arrays.fill(visit, -1);
        dfs(vertex, 0);
        return result;
    }

    private static void dfs(int vertex, int length) {
        if (visit[vertex] != -1) {
            return;
        }
        if (result < length) {
            result = length;
        }
        visit[vertex] = length;
        for (int i = 0; i < adj[vertex].size(); i++) {
            Data data = adj[vertex].get(i);
            dfs(data.vertex, data.weight + length);
        }
    }

    private static int getFarthermostVertex(int vertex) {
        int index = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < visit.length; i++) {
            if (visit[i] > max) {
                max = visit[i];
                index = i;
            }
        }
        return index;
    }
}

class Data {

    int vertex;
    int weight;

    public Data(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
}
