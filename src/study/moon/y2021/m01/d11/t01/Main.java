package study.moon.y2021.m01.d11.t01;

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

//https://www.acmicpc.net/problem/1197    [G4]    최소 스패닝 트리
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

        //양방향(Prim)
        for (int i = 1; i <= edge; i++) {
            s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            int weight = Integer.parseInt(s[2]);
            graph[start].add(new Data(start, end, weight));
            graph[end].add(new Data(end, start, weight));
        }

        int answer = 0;
        List<Data> prim = prim(1);
        for (Data data : prim) {
            answer+=data.weight;
        }
        bw.write(answer+"");
        bw.flush();
        bw.close();
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

}
