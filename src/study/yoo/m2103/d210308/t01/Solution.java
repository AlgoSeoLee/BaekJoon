package study.yoo.m2103.d210308.t01;

// 등굣길 3
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] route = new int[n][m];
        int mod = 1000000007;
        
        route[0][0] = 1;
        
        for(int[] puddle : puddles) {
            route[puddle[1] - 1][puddle[0] - 1] = -1;
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(route[i][j] == -1) { // 웅덩이 있는 곳
                    route[i][j] = 0;
                    continue;
                }
                if(i != 0) {
                    route[i][j] += route[i - 1][j] % mod;
                }
                if(j != 0) {
                    route[i][j] += route[i][j - 1] % mod;
                }
            }
        }
        answer = route[n - 1][m - 1] % mod;
        
        return answer;
    }
}
