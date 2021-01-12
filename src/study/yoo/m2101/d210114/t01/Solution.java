package study.yoo.m2101.d210114.t01;


class Solution {
	public int[] solution(int n, int s) {
		int[] answer = new int[n];
		
		if(n > s) 
            return new int[] {-1}; 
        
        if(s % n == 0) {   
            for(int i = 0 ; i < n; i++) {
                answer[i] = s / n;
            }
            
        }else {           
            int index = n - (s % n);   
            for(int i = 0; i < index; i++) { 
                answer[i] = s / n;
            }
            for(int i = index; i < n; i++) {  
                answer[i] = s / n +1;
            }
        }
        return answer;
    }

}


