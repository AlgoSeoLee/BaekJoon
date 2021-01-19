package study.yoo.m2101.d210118.t01;

//가장 먼 노드
import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        int dist[] = new int[n+1];
        //양방향 변환
        boolean visit[][] = new boolean[n+1][n+1];
        for(int i = 0; i < edge.length; i++){
            visit[edge[i][0]][edge[i][1]] = true;
            visit[edge[i][1]][edge[i][0]] = true;
        }
        
        Queue<Integer> queue = new LinkedList();
        //1번 노드로부터 가장 먼 노드 찾을거임 
        queue.add(1);
        int max = 0;
        //bfs
        while(!queue.isEmpty()){
            int index = queue.poll();
            for(int i = 2; i <= n; i++){
                if(dist[i] == 0 && visit[index][i]){
                    dist[i] = dist[index] + 1;
                    queue.add(i);
                }
            }
        }
        for(int i = 0; i <= n; i++){
            max = Math.max(max, dist[i]);
        }
        int count = 0;
        for(int i = 0; i <= n; i++){
           if(max == dist[i])
                count++;
        }

        return count;
    }
}