package study.yoo.d201109.t02;

import java.util.Scanner;

//https://www.acmicpc.net/problem/1316
public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		int inputCnt = Integer.valueOf(input);
		int result = inputCnt;

		for (int i = 0; i < inputCnt; i++) {
			String inputStr = sc.nextLine();
			int[] chk = new int[26];

			for (int j = 1; j < inputStr.length(); j++) {
				chk[inputStr.charAt(0) - 'a'] = 1;

				if (inputStr.charAt(j) != inputStr.charAt(j - 1)) {
					if (chk[inputStr.charAt(j) - 'a'] == 0) {
						chk[inputStr.charAt(j) - 'a'] = 1;
					} else {
						result = result - 1;
						break;
					}
				}
			}
			chk = new int[26];
		}

		System.out.println(result);
		sc.close();
	}

}
