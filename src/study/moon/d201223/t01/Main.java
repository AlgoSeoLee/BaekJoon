package study.moon.d201223.t01;

//https://www.acmicpc.net/problem/1753
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    static int vertex, edge;
    static ArrayList<ArrayList<Node>> list; // 인접리스트.

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] split = br.readLine().split(" ");
        vertex = Integer.parseInt(split[0]);
        edge = Integer.parseInt(split[1]);
        list = new ArrayList<>();

        for (int i = 0; i <= vertex; i++) {
            list.add(new ArrayList<>());
        }

        int k = Integer.parseInt(br.readLine());

        // 단방향 인접 리스트 구현.
        for (int i = 0; i < edge; i++) {
            String[] strings = br.readLine().split(" ");
            int start = Integer.parseInt(strings[0]);
            int end = Integer.parseInt(strings[1]);
            int weight = Integer.parseInt(strings[2]);

            // start에서 end로 가는 weight (가중치)
            list.get(start).add(new Node(end, weight));
        }

        int[] dijkstra = dijkstra(k);
        for (int i = 1; i < dijkstra.length; i++) {
            if (dijkstra[i]==Integer.MAX_VALUE) {
                bw.write("INF\n");
                continue;
            }
            bw.write(dijkstra[i]+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    // 다익스트라 알고리즘
    public static int[] dijkstra(int start) {
        PriorityQueue<Node> heap = new PriorityQueue<>();
        boolean[] check = new boolean[vertex + 1];
        int[] dist = new int[vertex + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        heap.offer(new Node(start, 0));
        dist[start] = 0;

        while (!heap.isEmpty()) {
            Node curNode = heap.poll();
            int index = curNode.index;

            if (!check[index]) {
                check[index] = true;
                for (Node node : list.get(index)) {
                    if (!check[node.index] && dist[node.index] > dist[index] + node.data) {
                        dist[node.index] = dist[index] + node.data;
                        heap.add(new Node(node.index, dist[node.index]));
                    }
                }
            }
        }
        return dist;
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
