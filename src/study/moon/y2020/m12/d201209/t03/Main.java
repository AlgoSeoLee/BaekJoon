package study.moon.y2020.m12.d201209.t03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

// https://www.acmicpc.net/problem/1389

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

//        // 단방향 인접 리스트 구현.
//        for (int i = 0; i < edge; i++) {
//            String[] strings = br.readLine().split(" ");
//            int start = Integer.parseInt(strings[0]);
//            int end = Integer.parseInt(strings[1]);
//
//            // start에서 end로 가는 weight (가중치)
//            list.get(start).add(new Node(end, 1));
//        }
        //양방향 인접리스트 구현

        for (int i = 0; i < edge; i++) {
            String[] strings = br.readLine().split(" ");
            int start = Integer.parseInt(strings[0]);
            int end = Integer.parseInt(strings[1]);

            // start에서 end로 가는 weight (가중치)
            list.get(start).add(new Node(end, 1));
            list.get(end).add(new Node(start,1));
        }


        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = vertex; i >= 1; i--) {
            int sum = 0;
            for (int j = 1; j <= vertex; j++) {
                sum += dijkstra(i,j);
            }
            if(sum <= min) {
                min = sum;
                minIndex = i;
            }
        }

        bw.write(minIndex+"");
        bw.flush();
        bw.close();
        br.close();
    }

    // 다익스트라 알고리즘
    public static int dijkstra(int start, int end) {
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
        return dist[end];
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
