package study.moon.y2021.m01.d28;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;

//https://www.acmicpc.net/problem/2252    [G2]    줄 세우기
public class Main {

    static int vertex; //정점 개수
    static int edge; //간선 개수
    static ArrayList<Integer>[] adj; //각 정점이 향하고 있는 정점들을 가진 리스트

    static LinkedList<Integer> queue = new LinkedList<>(); //작업 수행용 큐

    static ArrayList<Integer> sortedList = new ArrayList<>(); //정렬 결과용 큐

    static int[] targetedNodeCount;
    static int[] time;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        vertex = Integer.parseInt(s[0]);
        edge = Integer.parseInt(s[1]);
        time = new int[vertex + 1];
        adj = new ArrayList[vertex + 1];
        targetedNodeCount = new int[vertex + 1];
        for (int i = 1; i <= vertex; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < edge; i++) {
            s = br.readLine().split(" ");
            int end = Integer.parseInt(s[0]);
            adj[end].add(Integer.parseInt(s[1]));
            targetedNodeCount[Integer.parseInt(s[1])]++;

        }

        //최상위 정점들을 큐에 추가한다.
        for (int i = 1; i <= vertex; i++) {
            if (targetedNodeCount[i] == 0) {
                queue.add(i);
            }
        }

        //로직 시작
        while (!queue.isEmpty()) {
            int current = queue.poll();
            sortedList.add(current);
            for (int i = 0; i < adj[current].size(); i++) {
                int next = adj[current].get(i);
                targetedNodeCount[next]--;
                if (targetedNodeCount[next] == 0) {
                    queue.add(next);
                }
            }
        }

        //마무리 출력
        for (Integer integer : sortedList) {
            bw.write(integer + " ");
        }
        bw.flush();
        bw.close();

    }
}
