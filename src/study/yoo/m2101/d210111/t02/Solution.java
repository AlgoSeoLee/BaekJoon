package study.yoo.m2101.d210111.t02;

import java.util.*;

//같은 숫자는 싫어
//https://programmers.co.kr/learn/courses/30/lessons/12906
public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int a = 10;
        for(int num : arr) {
            if(a != num)
            	list.add(num);
            a = num;
        }       
        int[] answer = new int[list.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = list.get(i).intValue();
        }
        return answer;
    }
}
