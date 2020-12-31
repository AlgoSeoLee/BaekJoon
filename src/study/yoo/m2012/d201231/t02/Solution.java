package study.yoo.m2012.d201231.t02;

import java.util.HashMap;

//위장
//https://programmers.co.kr/learn/courses/30/lessons/42578
class Solution {
    public int solution(String[][] clothes) {
    	int answer = 1; 

    	HashMap<String, Integer> map = new HashMap<>();
    	
    	for(int i = 0; i < clothes.length; i++) {
            // 수량 세기
    		if(map.get(clothes[i][1]) == null)
    			map.put(clothes[i][1], 1);
    		else
    			//종류 같은 거 있으면 더해주기
    			map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
    	}
    	
    	for(String keys: map.keySet()) {
            //착용 안한 경우도 있으니 1 더해줌
    		answer *= (map.get(keys) + 1);
    	}
        //다 벗은경우 제외
        return answer -1;
    }
}