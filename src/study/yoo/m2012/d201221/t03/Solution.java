package study.yoo.m2012.d201221.t03;

import java.util.Collections;
import java.util.PriorityQueue;

//이중 우선순위 큐
public class Solution {
	public int[] solution(String[] operations) {
		int[] answer = { 0, 0 };

		// 우선순위 낮은 숫자 순
		PriorityQueue<Integer> priorityQueueMin = new PriorityQueue<>();
		// 우선순위 높은 숫자 순
		PriorityQueue<Integer> priorityQueueMax = new PriorityQueue<>(Collections.reverseOrder());

		// java foreach loop문
		for (String operation : operations) {
			String[] splitOp = operation.split(" ");

			if (splitOp[0].equals("I")) {
				priorityQueueMin.offer(Integer.parseInt(splitOp[1]));
				priorityQueueMax.offer(Integer.parseInt(splitOp[1]));
			}

			if (splitOp[0].equals("D")) {
				if (!priorityQueueMax.isEmpty()) {
					if (splitOp[1].equals("1")) {
						priorityQueueMin.remove(priorityQueueMax.peek());
						priorityQueueMax.poll();
					} else if (splitOp[1].equals("-1")) {
						priorityQueueMax.remove(priorityQueueMin.peek());
						priorityQueueMin.poll();
					}
				}
			}
		}

		if (!priorityQueueMax.isEmpty()) {
			answer[0] = priorityQueueMax.peek();
			answer[1] = priorityQueueMin.peek();
		}
		return answer;
	}
}
