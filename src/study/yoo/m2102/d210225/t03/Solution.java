package study.yoo.m2102.d210225.t03;

// n으로 표현 3
//미완성
class Solution {
	static int answer = 0;
	
    public int solution(int N, int number) {
        
        return answer > 8 ? -1 : answer;
    }
    
	static void dfs(int n, int number, int count, int sum) {
		
		int temp = n;
		if (count <= 8) {
			if (sum == number) {
				answer = Math.min(count, answer);
			}
			
			for (int i = 1; i <= 8; i++) {
				temp = temp * 10 + n;
				dfs(n, number, count + i, sum + temp);
				dfs(n, number, count + i, sum - temp);
				dfs(n, number, count + i, sum / temp);
				dfs(n, number, count + i, sum * temp);
			}
		}

	}
}