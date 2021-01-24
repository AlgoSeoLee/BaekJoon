package study.yoo.m2101.d210125.t03;

//네트워크
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[computers.length];
        
        for(int i = 0; i < computers.length; i++){
            visited[i] = false;
        }
        
        for(int i = 0; i < computers.length; i++){
            if(visited[i] == false){
                dfs(i, visited, computers);
                answer++;
            }
        }
        return answer;
    }
    public void dfs(int node, boolean[] visited, int[][] computers){
        visited[node] = true;
        
        for(int i = 0; i < computers.length; i++){
            if(visited[i] == false && computers[node][i] == 1){
                dfs(i, visited, computers);
            }
        }
    }
}