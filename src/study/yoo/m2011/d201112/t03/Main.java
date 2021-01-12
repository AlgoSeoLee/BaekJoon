package study.yoo.m2011.d201112.t03;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		int[] num = {6, 10, 2};
		int[] num1 = {3, 30, 34, 5, 9};
		System.out.println(solution(num));
		System.out.println(solution(num1));
	}

	public static String solution(int[] numbers) {
		StringBuilder answer = new StringBuilder();
		String[] arr = new String[numbers.length];

		// 문자열로 변경
		for (int i = 0; i < numbers.length; i++)
			arr[i] = String.valueOf(numbers[i]);

		Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

		if (arr[0].equals("0")) {
			return "0";
		}

		for (String s : arr) {
			answer.append(s);
		}
		return answer.toString();
	}
}
