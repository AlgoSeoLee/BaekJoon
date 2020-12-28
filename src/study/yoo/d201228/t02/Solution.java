package study.yoo.d201228.t02;

import java.util.Arrays;

//완주하지 못한 선수
//https://programmers.co.kr/learn/courses/30/lessons/42576

class Solution {
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        int i;
        for(i = 0; i<completion.length; i++) {
        	if(!participant[i].equals(completion[i])) {
        		return participant[i];
        	}
        }
        return participant[i];
        
    }
}
