package study.moon.y2021.m01.d10.t02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;

//https://www.acmicpc.net/problem/1005    [G3]    ACM 크래프트    <발표>
public class Main {

    static int vertex; //정점 개수
    static int edge; //간선 개수
    static ArrayList<Integer>[] adj; //각 정점이 향하고 있는 정점들을 가진 리스트

    static LinkedList<Integer> queue = new LinkedList<>(); //작업 수행용 큐

    static ArrayList<Integer> sortedList = new ArrayList<>(); //정렬 결과용 큐

    static int[] weight;

    static int[] time;

    static int[] targetedNodeCount;

    static int target;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            //초기화
            String[] s = br.readLine().split(" ");
            vertex = Integer.parseInt(s[0]);
            edge = Integer.parseInt(s[1]);
            adj = new ArrayList[vertex + 1];
            targetedNodeCount = new int[vertex + 1];
            for (int j = 1; j <= vertex; j++) {
                adj[j] = new ArrayList<>();
            }
            weight = new int[vertex + 1];
            s = br.readLine().split(" ");
            for (int j = 1; j <= vertex; j++) {
                weight[j] = Integer.parseInt(s[j - 1]);
            }
            time = new int[vertex + 1];

            //인접행렬, 방향성리스트 추가
            for (int j = 0; j < edge; j++) {
                s = br.readLine().split(" ");
                int start = Integer.parseInt(s[0]);
                int end = Integer.parseInt(s[1]);
                adj[start].add(end);
                targetedNodeCount[end]++;
            }

            //타겟 추가
            target = Integer.parseInt(br.readLine());

            //최상위 정점들을 큐에 추가한다.
            for (int j = 1; j <= vertex; j++) {
                if (targetedNodeCount[j] == 0) {
                    queue.add(j);
                    time[j] = weight[j];
                }
            }

            //로직 시작
            while (!queue.isEmpty()) {
                int current = queue.poll();
                sortedList.add(current);
                for (int j = 0; j < adj[current].size(); j++) {
                    int next = adj[current].get(j);

                    if (time[current] + weight[next] > time[next]) {
                        time[next] = time[current] + weight[next];
                    }

                    targetedNodeCount[next]--;
                    if (targetedNodeCount[next] == 0) {
                        queue.add(next);
                    }
                }
            }

            //마무리 출력
            bw.write(time[target]+"\n");
        }

        bw.flush();
        bw.close();

    }
}
