package study.CheatSheet.BellmanFord;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static int INF = Integer.MAX_VALUE;
    static Data[] adj;
    static int vertex;
    static int edge;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] split = br.readLine().split(" ");
        vertex = Integer.parseInt(split[0]);
        edge = Integer.parseInt(split[1]);

        adj = new Data[edge];

        for (int i = 0; i < edge; i++) {
            split = br.readLine().split(" ");
            int start = Integer.parseInt(split[0]);
            int end = Integer.parseInt(split[1]);
            int weight = Integer.parseInt(split[2]);

            adj[i] = new Data(start, end, weight);
        }

        long[] dist = bellmanFord(1);
        boolean check = isLoop(edge, dist);

        if (check) {
            // 무한루프시
            bw.write("-1\n");
        } else {
            for (int i = 2; i <= vertex; i++) {
                if (dist[i] == INF) {
                    //도달불능시
                    bw.write("-1\n");
                } else {
                    bw.write(dist[i]+"\n");
                }
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
            for (int j = 0; j < edge; j++) {
                if (dist[adj[j].start] == INF) {
                    continue;
                }
                if (dist[adj[j].end] > (dist[adj[j].start] + adj[j].weight)) {
                    dist[adj[j].end] = dist[adj[j].start] + adj[j].weight;
                }
            }
        }
        return dist;
    }

    private static boolean isLoop(int edge, long[] dist) {
        boolean check = false;

        for (int i = 0; i < edge; i++) {
            if (dist[adj[i].start] == INF) {
                continue;
            }
            if (dist[adj[i].end] > dist[adj[i].start] + adj[i].weight) {
                check = true;
                break;
            }
        }
        return check;
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
}
