package study.yoo.d201112.t01;

// 피보나치
public class Main {

	public static void main(String[] args) {
		System.out.println(solution(3));
		System.out.println(solution(5));
		
	}

	public static int solution(int n) {
		int answer = 0;
		if (n == 1 || n == 2)
			return 1;
		
		int n1 = 1, n2 = 1;
		for (int i = 3; i <= n; i++) {
			answer = n1 + n2;
			answer %= 1234567;
			n1 = n2;
			n2 = answer;
		}
		return answer;
	}

}
