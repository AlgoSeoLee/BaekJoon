package study.yoo.m2102.d210201.t01;

import java.util.*;

//야근지수
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
		
        long sum = 0;
		for(long work: works) {
			pq.add(work);
            sum += work;
		}
		
        if(sum <= n)
            return 0;
        
		for(int i = 0; i < n; i++) {
			long now = pq.poll();
			pq.add(now - 1);
		}
		
		for(long i : pq)
			answer += (i * i);
        return answer;
    }
}