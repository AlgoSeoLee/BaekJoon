package study.CheatSheet.TopologicalSort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Main {

    static int vertex; //정점 개수
    static int edge; //간선 개수
    static ArrayList<Integer>[] adj; //각 정점이 향하고 있는 정점들을 가진 리스트

    static LinkedList<Integer> queue = new LinkedList<>(); //작업 수행용 큐

    static ArrayList<Integer> sortedList = new ArrayList<>(); //정렬 결과용 큐

    static int[] targetedNodeCount;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        vertex = Integer.parseInt(s[0]);
        edge = Integer.parseInt(s[1]);
        adj = new ArrayList[vertex + 1];
        targetedNodeCount = new int[vertex + 1];
        for (int i = 1; i <= vertex; i++) {
            adj[i] = new ArrayList<>();
        }

        //인접행렬, 방향성리스트 추가
        for (int i = 0; i < edge; i++) {
            s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            adj[start].add(end);
            targetedNodeCount[end]++;
        }

        //최상위 정점들을 큐에 추가한다.
        for (int i = 1; i <= vertex; i++) {
            if (targetedNodeCount[i] == 0) {
                queue.add(i);
            }
        }

        //로직 시작
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            sortedList.add(currentNode);
            for (int i = 0; i < adj[currentNode].size(); i++) {
                int getArrowNode = adj[currentNode].get(i);
                targetedNodeCount[getArrowNode]--;
                if (targetedNodeCount[getArrowNode] == 0) {
                    queue.add(getArrowNode);
                }
            }
        }

        //큐에 넣은것들이 다 넣어지고 나면 여지껏 들어온 정점들을 순서대로 출력하고 종료
        for (int i = 0; i < sortedList.size(); i++) {
            bw.write(sortedList.get(i)+"");
            if (i != sortedList.size()) {
                bw.write(" ");
            }
        }
        bw.flush();
        bw.close();

    }
}

//문자열
//public class Main {
//
//    static int vertex; //정점 개수
//    static int edge; //간선 개수
//    static Map<String, ArrayList<String>> adj; //각 정점이 향하고 있는 정점들을 가진 리스트
//
//    static LinkedList<String> queue = new LinkedList<>(); //작업 수행용 큐
//
//    static ArrayList<String> sortedList = new ArrayList<>(); //정렬 결과용 큐
//
//    static Map<String, Integer> targetedNodeCount;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        String[] arr = br.readLine().split(" ");
//        vertex = arr.length;
//        edge = Integer.parseInt(br.readLine());
//        adj = new HashMap<>();
//        targetedNodeCount = new HashMap<>();
//        for (int i = 0; i < vertex; i++) {
//            adj.put(arr[i], new ArrayList<>());
//        }
//        for (int i = 0; i < vertex; i++) {
//            targetedNodeCount.put(arr[i], 0);
//        }
//
//        //인접행렬, 방향성리스트 추가
//        for (int i = 0; i < edge; i++) {
//            String[] s = br.readLine().split(" ");
//            String start = s[0];
//            String end = s[1];
//            adj.get(start).add(end);
//            targetedNodeCount.put(end, targetedNodeCount.get(end) + 1);
//        }
//
//        //최상위 정점들을 큐에 추가한다.
//        for (int i = 0; i < vertex; i++) {
//            if (targetedNodeCount.getOrDefault(arr[i], 0) == 0) {
//                queue.add(arr[i]);
//            }
//        }
//
//        //로직 시작
//        while (!queue.isEmpty()) {
//            String currentNode = queue.poll();
//            sortedList.add(currentNode);
//            for (int i = 0; i < adj.get(currentNode).size(); i++) {
//                String getArrowNode = adj.get(currentNode).get(i);
//                targetedNodeCount.put(getArrowNode, targetedNodeCount.get(getArrowNode) - 1);
//                if (targetedNodeCount.get(getArrowNode) == 0) {
//                    queue.add(getArrowNode);
//                }
//            }
//        }
//
//        //큐에 넣은것들이 다 넣어지고 나면 여지껏 들어온 정점들을 순서대로 출력하고 종료
//        for (int i = 0; i < sortedList.size(); i++) {
//            bw.write(sortedList.get(i) + "");
//            if (i != sortedList.size()) {
//                bw.write(" ");
//            }
//        }
//        bw.flush();
//        bw.close();
//
//    }
//}
