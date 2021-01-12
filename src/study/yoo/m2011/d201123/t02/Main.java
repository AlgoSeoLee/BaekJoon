package study.yoo.m2011.d201123.t02;

public class Main {

	public static void main(String[] args) {
		System.out.println(solution(8, 4, 7));
		
	}

	    public static int solution(int n, int a, int b){
	        int answer = 0;
	        
	        while(a != b) {
	            a = a%2 == 1 ? (a+1)/2 : a/2;
	            b = b%2 == 1 ? (b+1)/2 : b/2;
	            answer+=1;
	        }

	        return answer;
	    }
}
