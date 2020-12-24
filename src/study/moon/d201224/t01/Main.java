package study.moon.d201224.t01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static final int INF = Integer.MAX_VALUE;
    static Data[] adj;
    static int vertex;
    static int edge;
    static int wormhole;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int TC = Integer.parseInt(br.readLine());
        for (int i = 0; i < TC; i++) {
            String[] split = br.readLine().split(" ");
            vertex = Integer.parseInt(split[0]);
            edge = Integer.parseInt(split[1]);
            wormhole = Integer.parseInt(split[2]);

            adj = new Data[2 * edge + wormhole];

            for (int j = 0; j < 2 * edge; j += 2) {
                split = br.readLine().split(" ");
                int start = Integer.parseInt(split[0]);
                int end = Integer.parseInt(split[1]);
                int weight = Integer.parseInt(split[2]);
                adj[j] = new Data(start, end, weight);
                adj[j + 1] = new Data(end, start, weight);
            }

            for (int j = 2 * edge; j < 2 * edge + wormhole; j++) {
                split = br.readLine().split(" ");
                int start = Integer.parseInt(split[0]);
                int end = Integer.parseInt(split[1]);
                int weight = Integer.parseInt(split[2]);
                adj[j] = new Data(start, end, -weight);
            }

            long[] dist = bellmanFord(1);
            boolean check = isLoop(2 * edge + wormhole, dist);
            if (check) {
                bw.write("YES\n");
            }else {
                bw.write("NO\n");
            }
        }
        bw.flush();
        bw.close();
    }

    private static long[] bellmanFord(int start) {
        long[] dist = new long[vertex + 1];
        for (int i = 1; i <= vertex; i++) {
            dist[i] = INF;
        }
        dist[start] = 0;

        for (int i = 0; i < vertex - 1; i++) {
            for (int j = 0; j < 2 * edge + wormhole; j++) {
                if (dist[adj[j].end] > (dist[adj[j].start] + adj[j].weight)) {
                    dist[adj[j].end] = dist[adj[j].start] + adj[j].weight;
                }
            }
        }
        return dist;
    }

    private static boolean isLoop(int edge, long[] dist) {
        for (int i = 0; i < edge; i++) {
            if (dist[adj[i].start] == INF) {
                continue;
            }
            if (dist[adj[i].end] > dist[adj[i].start] + adj[i].weight) {
                return true;
            }
        }
        return false;
    }
}

class Data {

    int start;
    int end;
    int weight;

    public Data(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
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
