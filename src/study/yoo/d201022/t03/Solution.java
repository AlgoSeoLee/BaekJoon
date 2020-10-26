package study.yoo.d201022.t03;

import study.yoo.d201022.t03.Solution;


// n을 뒤집어서 배열에 저장해서 출력
public class Solution {

	public static void main(String[] args) {
		 Solution solution = new Solution();
		System.out.println(solution.solution(12345));

	}



	    public int[] solution(long n) {
	        int[] answer = new int[String.valueOf(n).length()];
	        // String.valueOf(n).length() 사용 안하면 Index 0 out of bounds for length 0 에러가남
	        // 배열 길이때문에 에러난거 같아서 String.valueOf(n) 함수를 사용해 n을 문자열로 바꾸고 길이를 구해서 정해줌

	        int i =0;

	        while( n>0){
	            answer[i] = (int) (n % 10);
	            n = n/10;
	            i++;
	        }
	        return answer;
	}
}
