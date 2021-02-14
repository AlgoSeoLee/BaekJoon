package study.yoo.m2102.d210215.t01;

//멀쩡한 사각형 2
public class Solution {

	public static void main(String[] args) {
		int w = 8;
		int h = 7;
		long a = solution(w, h);
		System.out.println(a);
	}

	public static long solution(int w, int h) {
		long answer = 1;
		long min = (long) h;
		long max = (long) w;
		long value = 1;

		while (value > 0) {
			value = max % min;
			max = min;
			min = value;
		}

		answer = (long) w * (long) h - ((long) w + (long) h - max);
		return answer;
	}
}