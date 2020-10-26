package study.yoo.d201022.t03;

import java.util.Arrays;


// n을 뒤집어서 배열에 저장해서 출력
public class Solution {

	public static void main(String[] args) {
		 Solution solution = new Solution();
		 System.out.println(Arrays.toString(solution.solution(12345)));
	}

	public int[] solution(long n) {
		String s = Long.toString(n);
		int[] answer = new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
			answer[s.length()-i-1] = Character.getNumericValue(s.charAt(i));
		}
		return answer;
	}

//	    public int[] solution(long n) {
//	        int[] answer = new int[String.valueOf(n).length()];
//	        // String.valueOf(n).length() 사용 안하면 Index 0 out of bounds for length 0 에러가남
//	        // 배열 길이때문에 에러난거 같아서 String.valueOf(n) 함수를 사용해 n을 문자열로 바꾸고 길이를 구해서 정해줌
//
//	        int i =0;
//
//	        while( n>0){
//	            answer[i] = (int) (n % 10);
//	            n = n/10;
//	            i++;
//	        }
//	        return answer;
//	}
}
