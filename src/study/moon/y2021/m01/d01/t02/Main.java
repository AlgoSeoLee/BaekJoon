package study.moon.y2021.m01.d01.t02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    static int vertex, edge;
    static ArrayList<ArrayList<Node>> list; // 인접리스트.

    static int cost;
    static List<Integer> path = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        vertex = Integer.parseInt(br.readLine());
        edge = Integer.parseInt(br.readLine());
        list = new ArrayList<>();

        for (int i = 0; i <= vertex; i++) {
            list.add(new ArrayList<>());
        }

        // 단방향 인접 리스트 구현.
        for (int i = 0; i < edge; i++) {
            String[] strings = br.readLine().split(" ");
            int start = Integer.parseInt(strings[0]);
            int end = Integer.parseInt(strings[1]);
            int weight = Integer.parseInt(strings[2]);

            // start에서 end로 가는 weight (가중치)
            list.get(start).add(new Node(end, weight));
        }

        String[] split = br.readLine().split(" ");

        dijkstra(Integer.parseInt(split[0]),Integer.parseInt(split[1]));

        System.out.println(path);
        bw.flush();
        bw.close();
        br.close();
    }

    // 다익스트라 알고리즘
    public static void dijkstra(int start, int end) {
        PriorityQueue<Node> heap = new PriorityQueue<>();
        boolean[] check = new boolean[vertex + 1];
        int[] dist = new int[vertex + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        heap.offer(new Node(start, 0));
        dist[start] = 0;
        path.add(start);
        path.add(end);

        while (!heap.isEmpty()) {
            Node curNode = heap.poll();
            int index = curNode.index;

            if (!check[index]) {
                check[index] = true;
                for (Node node : list.get(index)) {
                    if (!check[node.index] && dist[node.index] > dist[index] + node.data) {
                        dist[node.index] = dist[index] + node.data;
                        heap.add(new Node(node.index, dist[node.index]));
                        if (!path.contains(index)) {
                            path.add(path.size()-1,index);
                        }
                    }
                }
            }
        }
        cost = dist[end];
    }
}

class Node implements Comparable<Node> {
    int index;
    int data;

    Node(int index, int data) {
        this.index = index;
        this.data = data;
    }

    @Override
    public int compareTo(Node o) {
        return data - o.data;
    }

}
