package study.yoo.m2102.d210225.t01;

// 이진변환 반복하기 2
class Solution {
	public int[] solution(String s) {
		int[] answer = { 0, 0 };

		while (!s.equals("1")) {
			answer[0]++; // 이진변환 횟수 (while문 돌때마다)
			int count = 0; // 1개수

			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '1') {
					count++;
				} else {
					answer[1]++; //제거된 0 갯수
				}
			}
			s = Integer.toBinaryString(count); //남은 1들 길이 이진변환
		}
		return answer;
	}
}
