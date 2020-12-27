package study.moon.y2020.m12.d201214.t02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
//https://www.acmicpc.net/problem/9205
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            Place[] places = new Place[n + 2];
            for (int j = 0; j < n + 2; j++) {
                String[] s = br.readLine().split(" ");
                int x = Integer.parseInt(s[0]);
                int y = Integer.parseInt(s[1]);
                places[j] = new Place(x, y);
            }

            ArrayList<ArrayList<Node>> list = new ArrayList<>();
            for (int j = 0; j < n + 2; j++) {
                list.add(new ArrayList<>());
            }

            //양방향 인접리스트 구현
            for (int j = 0; j < n + 2; j++) {
                for (int k = 0; k < n + 2; k++) {
                    // start에서 end로 가는 weight (가중치)
                    if (getDistance(places[j], places[k]) <= 1000 && getDistance(places[j], places[k]) >0) {
                        list.get(j).add(new Node(k, 1));
                    }
                }
            }

            if (dijkstra(0,n+1,n+2,list)==Integer.MAX_VALUE) {
                bw.write("sad\n");
            } else {
                bw.write("happy\n");
            }
        }
        bw.flush();
        bw.close();
    }

    public static int dijkstra(int start, int end, int size, ArrayList<ArrayList<Node>> list) {
        PriorityQueue<Node> heap = new PriorityQueue<>();
        boolean[] check = new boolean[size+1];
        int[] dist = new int[size+1];
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

    private static int getDistance(Place p1, Place p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }

}

class Place {

    int x;
    int y;


    public Place(int x, int y) {
        this.x = x;
        this.y = y;
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
