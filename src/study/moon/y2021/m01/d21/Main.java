package study.moon.y2021.m01.d21;

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

//https://www.acmicpc.net/problem/4386    [G4]    별자리 만들기
public class Main {

    static int vertex;
    static boolean[] visit;
    static ArrayList<Data>[] graph;
    static Place[] places;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        vertex = Integer.parseInt(br.readLine());
        graph = new ArrayList[vertex + 1];
        visit = new boolean[vertex + 1];
        places = new Place[vertex + 1];
        for (int i = 0; i <= vertex; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i <= vertex; i++) {
            String[] s = br.readLine().split(" ");
            places[i] = new Place(Double.parseDouble(s[0]), Double.parseDouble(s[1]));
        }

        //양방향(Prim)
        for (int i = 1; i <= vertex; i++) {
            for (int j = 1; j <= vertex; j++) {
                double weight = places[i].getDistanceWith(places[j]);
                graph[i].add(new Data(i, j, weight));
                graph[j].add(new Data(j, i, weight));
            }
        }

        List<Data> prim = prim(1);
        double answer = 0;
        for (Data data : prim) {
            answer += data.weight;
        }
        bw.write(String.format("%.2f", answer));
        bw.flush();
        bw.close();
        br.close();
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
    double weight;

    public Data(int start, int end, double weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Data o) {
        return Double.compare(this.weight,o.weight);
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

class Place {

    double x;
    double y;

    public Place(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getDistanceWith(Place place) {
        return Math.sqrt(Math.pow(this.x - place.x, 2) + Math.pow(this.y - place.y, 2));
    }

    @Override
    public String toString() {
        return "Place{" +
            "x=" + x +
            ", y=" + y +
            '}';
    }
}
