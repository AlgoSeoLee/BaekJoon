package study.yoo.m2103.d210303.t01;

import java.util.Arrays;

// 프로그래머스 숫자게임 3
class Solution {
	
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        
        int b_i = 0; 

        for(int a : A){
            for(int i = b_i; i < B.length; i++){
                if(a < B[i]){
                    b_i = i + 1;
                    answer++;
                    break;
                }
            }
        }
        
        return answer;
    }
}