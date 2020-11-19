package study.yoo.d201119.t01;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {

		int[] prices = {1, 2, 3, 2, 3};

		System.out.println(Arrays.toString(solution(prices)));
	}

	
    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        int time = 0;
        for(int i = 0; i < prices.length; i++) {
        	for(int j = i +1; j < prices.length; j++) {
        		time++;
        		if(prices[i] > prices[j]) // 유지되지 않았을 때 빠져나가게
        			break;
        	}
        		
        	answer[i] = time;
        	time = 0;

        }
  
        return answer;
    }

}



