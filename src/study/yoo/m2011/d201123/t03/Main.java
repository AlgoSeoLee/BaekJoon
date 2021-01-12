package study.yoo.m2011.d201123.t03;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		int[] priorities = {2, 1, 3, 2};
		System.out.println(solution(priorities, 2));
		}
	
	
	public static int solution(int[] priorities, int location) {
        int answer = 1;

        PriorityQueue q = new PriorityQueue<>(Collections.reverseOrder());

        for(int task : priorities){
            q.add(task);
            System.out.println(q);
        }
        //{2,5,4,1,3};

//        System.out.println(q);
        while(!q.isEmpty()){
            for(int i=0; i<priorities.length; i++){
                if(priorities[i] == (int)q.peek()) {
                    if(i == location){
                        return answer;
                    }
                    q.poll();
                    answer++;
                }
            }
        }

        return answer;
    }

}
