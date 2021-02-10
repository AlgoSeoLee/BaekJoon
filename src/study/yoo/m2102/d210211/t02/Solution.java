package study.yoo.m2102.d210211.t02;

import java.util.Stack;

//짝지어 제거하기 2
class Solution {
	public int solution(String s) {
		int answer = 0;
		
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (!stack.isEmpty() && stack.peek() == s.charAt(i))
				stack.pop();
			else
				stack.push(s.charAt(i));
		}
		answer = (stack.isEmpty()) ? 1 : 0;
		return answer;
	}
}
