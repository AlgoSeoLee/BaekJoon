package study.yoo.m2101.d210128.t03;

//멀리뛰기
class Solution {
    public long solution(int n) {
        long answer = 0;
        long[] dp = new long[n+1];
        
        if(n == 1) return 1; //런타임 에러때문에 넣음
        
        dp[1] = 1;
        dp[2] = 2;
        
        for(int i = 3; i <= n; i++) {
            dp[i] += (dp[i-1] + dp[i-2]) % 1234567;
        }

        return dp[n];
    }
}