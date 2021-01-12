package study.yoo.m2012.d201203.t03;

import java.util.*;

//더 맵게
public class Main {

	public static void main(String[] args) {

		int[] scoville1 = {1, 2, 3, 9, 10, 12};
		int k = 7;
		System.out.println(solution(scoville1, k));
	}

	public static int solution(int[] scoville, int K) {
		int answer = 0;
		int temp = 0, count = 0;
		int s1 = 0, s2 = 0;

		PriorityQueue<Integer> heap = new PriorityQueue();

		for (int i = 0; i < scoville.length; i++) {
			heap.offer(scoville[i]);
		}

		while (heap.size() > 1) {
			if (heap.peek() >= K) {
				answer = count;
				break;
			}
			s1 = heap.poll();
			s2 = heap.poll();
			temp = s1 + (s2 * 2);
			heap.offer(temp);
			count++;
		}

		if (heap.poll() >= K)
			answer = count;
		else
			answer = -1;

		return answer;
	}

}