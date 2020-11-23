package study.yoo.d201123.t01;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		int[] people = {70, 50, 80, 50};
		int[] people1 = {70, 80, 50};
		int limit = 100;
		System.out.println(solution(people, limit));
		System.out.println(solution(people1, limit));
	}

		public static int solution(int[] people, int limit) {
			int answer = 0;
			int i = 0;
	        int j;

			Arrays.sort(people);

			for(j=people.length-1; i<=j; j--) {

				if(people[j] + people[i] > limit)
					answer ++;

				else {
					answer ++;
					i ++;
				}
			}

			return answer;
		}


}
