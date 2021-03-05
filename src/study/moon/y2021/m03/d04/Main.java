package study.moon.y2021.m03.d04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
소마코테    소마스토리앤파이터
h g f w r
4
h g
h f
g r
g w
*/

public class Main {

    static int vertex; //정점 개수
    static int edge; //간선 개수
    static Map<String, LinkedList<String>> adj; //각 정점이 향하고 있는 정점들을 가진 리스트
    static Map<String, Integer> targetedNode;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] arr = br.readLine().split(" ");
        vertex = arr.length;
        edge = Integer.parseInt(br.readLine());

        adj = new HashMap<>();
        for (int i = 0; i < vertex; i++) {
            adj.put(arr[i], new LinkedList<>());
        }

        targetedNode = new HashMap<>();
        for (int i = 0; i < vertex; i++) {
            targetedNode.put(arr[i], 0);
        }

        //인접행렬, 방향성리스트 추가
        for (int i = 0; i < edge; i++) {
            String[] s = br.readLine().split(" ");
            String start = s[0];
            String end = s[1];
            adj.get(start).add(end);
            targetedNode.put(end, targetedNode.get(end) + 1);
        }

        //dfs 시작
        for (int i = 0; i < vertex; i++) {
            if (targetedNode.get(arr[i]) == 0) {
                List<String> answer = new ArrayList<>();
                answer.add(arr[i]);
                dfs(arr[i], answer);
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(String skill, List<String> answer) {
        if (adj.get(skill).size() == 0) {
            if (answer.size() == 1) {
                return;
            }
            for (String s : answer) {
                System.out.print(s + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < adj.get(skill).size(); i++) {
            String nowSkill = adj.get(skill).get(i);
            answer.add(nowSkill);
            dfs(nowSkill, answer);
            answer.remove(answer.size() - 1);
        }
    }
}
