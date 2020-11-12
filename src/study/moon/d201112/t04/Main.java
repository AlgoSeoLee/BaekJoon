package study.moon.d201112.t04;

import java.io.*;
import java.util.*;

//https://www.acmicpc.net/problem/1967
class Main {
    static ArrayList<Node>[] edges;
    static boolean[] visit;
    static int max = 0;
    static int maxIndex = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        edges = new ArrayList[N+1];
        for(int i=0; i<edges.length; i++){
            edges[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < N-1 ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            edges[parent].add(new Node(child,dist));
            edges[child].add(new Node(parent,dist));
            //그래프를 양방향 그래프로, 리스트의 형태로 담음
        }
        visit = new boolean[N+1];
        dfs(1,0);
        //Root 노드에서 제일 멀리 떨어진 노드 찾기
        int start = maxIndex;
        maxIndex = 0;
        max = 0;
        visit = new boolean[N+1];
        dfs(start,0);
        //지름을 구하기 위한 노드를 찾기
        System.out.print(max);
    }

    public static void dfs(int start, int weight){
        visit[start] = true;
        if(!edges[start].isEmpty()){
            for(Node child : edges[start]){
                if(!visit[child.x]){
                    if(max<weight+child.y){
                        max = weight+child.y;
                        maxIndex = child.x;
                    }
                    dfs(child.x, weight+child.y);
                }
            }
        }
    }
}

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
