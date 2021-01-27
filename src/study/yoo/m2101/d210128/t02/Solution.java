package study.yoo.m2101.d210128.t02;

class Solution {
    public int solution(int n) {
        int answer = 0;
        long[] dp = new long[n+1];
        dp[1] = 2;
        dp[2] = 3;
            if(n % 2 == 0){
            int div = 1000000007;

            for(int i=4; i<=n; i+=2){
                
                dp[i] = dp[i - 2] * 3;            
                dp[i - 1] = dp[i - 3] + dp[i - 4] * 2;
                dp[i] += dp[i - 1];
                dp[i] %= div;
            }
            answer = (int)dp[n];
        }

        return answer;
    }
}
