package study.yoo.d201022.t01;

import study.yoo.d201022.t01.Solution;

// a 에서 b까지 합 구하기

public class Solution {

	public static void main(String[] args) {
		 Solution solution = new Solution();
		 System.out.println(solution.solution(4, 6));

	}

	public long solution(int a, int b) {
        long answer = 0;

        if(a>b){
            for(int i = b; i<=a; i++){
                answer += i;
            }
        }
        else if(b>a){
            for(int i = a; i<=b; i++){
                answer += i;
            }
        }
        else 
            answer = a;


        return answer;
    }
	
}
