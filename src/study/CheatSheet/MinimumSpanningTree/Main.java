package study.CheatSheet.MinimumSpanningTree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    static int vertex, edge;
    static boolean[] visit;
    static ArrayList<Data>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        vertex = Integer.parseInt(s[0]);
        edge = Integer.parseInt(s[1]);
        graph = new ArrayList[vertex + 1];
        visit = new boolean[vertex + 1];
        for (int i = 0; i <= vertex; i++) {
            graph[i] = new ArrayList<>();
        }

        //단방향(Prim)
//        for (int i = 1; i <= edge; i++) {
//            s = br.readLine().split(" ");
//            int start = Integer.parseInt(s[0]);
//            int end = Integer.parseInt(s[1]);
//            int weight = Integer.parseInt(s[2]);
//            graph[start].add(new Data(start, end, weight));
//        }

        //양방향(Prim)
//        for (int i = 1; i <= edge; i++) {
//            s = br.readLine().split(" ");
//            int start = Integer.parseInt(s[0]);
//            int end = Integer.parseInt(s[1]);
//            int weight = Integer.parseInt(s[2]);
//            graph[start].add(new Data(start, end, weight));
//            graph[end].add(new Data(end, start, weight));
//        }

        //kruskal
        PriorityQueue<Data> pq = new PriorityQueue<>();
        for (int i = 1; i <= edge; i++) {
            s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            int weight = Integer.parseInt(s[2]);
            pq.add(new Data(start, end, weight));
        }

        List<Data> prim = prim(1);
        List<Data> kruskal = kruskal(pq);
    }

    private static List<Data> kruskal(PriorityQueue<Data> pq) {
        ArrayList<Data> MST = new ArrayList<>();
        int[] parent = new int[vertex + 1];
        for (int i = 0; i <= vertex; i++) {
            parent[i] = i;
        }

        while (MST.size() < (vertex - 1)) {
            Data data = pq.poll();
            if (find(data.start, parent) != find(data.end, parent)) {
                MST.add(data);
                union(data.start, data.end, parent);
            }
        }
        return MST;
    }

    private static List<Data> prim(int start) {
        PriorityQueue<Data> pq = new PriorityQueue<>();
        Queue<Integer> queue = new LinkedList<>();
        List<Data> MST = new ArrayList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            visit[poll] = true;
            for (Data data : graph[poll]) {
                if (!visit[data.end]) {
                    pq.add(data);
                }
            }
            while (!pq.isEmpty()) {
                Data e = pq.poll();
                if (!visit[e.end]) {
                    queue.add(e.end);
                    visit[e.end] = true;
                    MST.add(e);
                    break;
                }
            }
        }
        return MST;
    }

    public static int find(int n, int[] parent) {
        if (n == parent[n]) {
            return n;
        } else {
            int p = find(parent[n], parent);
            parent[n] = p;
            return p;
        }
    }

    public static void union(int n1, int n2, int[] parent) {
        int p1 = find(n1, parent);
        int p2 = find(n2, parent);

        if (p1 != p2) {
            parent[p1] = p2;
        }
    }
}

class Data implements Comparable<Data> {

    int start;
    int end;
    int weight;

    public Data(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Data o) {
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
        return "Data{" +
            "start=" + start +
            ", end=" + end +
            ", weight=" + weight +
            '}';
    }
}
