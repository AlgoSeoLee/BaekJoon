package study.codingTest.line.t01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {

    int vertex;
    ArrayList<ArrayList<Node>> list;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        vertex = n;
        list = new ArrayList<>();
        for (int i = 0; i <= vertex; i++) {
            list.add(new ArrayList<>());
        }

        //양방향 인접리스트 구현
        for (int[] fare : fares) {
            int start = fare[0];
            int end = fare[1];
            int weight = fare[2];

            // start에서 end로 가는 weight (가중치)
            list.get(start).add(new Node(end, weight));
            list.get(end).add(new Node(start, weight));
        }

        int[][] dp = new int[vertex+1][vertex+1];

        for (int i = 1; i <= vertex; i++) {
            dp[i] = dijkstra(i);
        }
        int[] dijkstra = dp[s].clone();

        for (int i = 1; i <= vertex; i++) {
            if (dijkstra[i]==Integer.MAX_VALUE) {
                continue;
            }

            int toA = dp[i][a];
            if (toA==Integer.MAX_VALUE) {
                dijkstra[i] = Integer.MAX_VALUE;
                continue;
            } else {
                dijkstra[i] += dp[i][a];
            }

            int toB = dp[i][b];
            if (toB==Integer.MAX_VALUE) {
                dijkstra[i] = Integer.MAX_VALUE;
            } else {
                dijkstra[i] += dp[i][b];
            }
        }
        int answer = Integer.MAX_VALUE;
        for (int j : dijkstra) {
            if (j < answer) {
                answer = j;
            }
        }
        return answer;
    }

    public int[] dijkstra(int start) {
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
