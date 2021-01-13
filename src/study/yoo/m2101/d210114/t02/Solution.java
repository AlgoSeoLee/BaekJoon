package study.yoo.m2101.d210114.t02;

public class Solution {
	public int solution(int n) {
		int answer = 0;
		int[] array = new int[n + 1];
		array[1] = 1;
		array[2] = 2;
		for (int i = 3; i <= n; i++) {
			array[i] = array[i - 1] + array[i - 2];
			array[i] %= 1000000007;
		}
		answer = array[n];
		return answer;

	}
}

