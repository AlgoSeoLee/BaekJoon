package study.yoo.d201102.t01;


public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.solution(15));
	}

    public int solution(int n) {
        int answer = 0;
        
        for(int i = 1; i<=n; i++){
            int sum = 0;
            for(int j = i; sum < n; j++){
                sum+=j;
                if(sum == n)
                    answer+=1;
            }
        }
        return answer;
    }
}
