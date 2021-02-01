package study.yoo.m2102.d210201.t01;

import java.util.Collections;
import java.util.PriorityQueue;

//야근지수
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder()); //역순 정렬
		
        long sum = 0;
		for(long work: works) {
			pq.add(work);
            sum += work;
		}
		
        if(sum <= n) // 야근없음
            return 0;
        
		for(int i = 0; i < n; i++) {
			long now = pq.poll(); //제일 큰 값부터 줄임
			pq.add(now - 1);
		}
		
		for(long i : pq)
			answer += (i * i);
        return answer;
    }
}