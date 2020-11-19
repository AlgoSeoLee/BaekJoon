package study.yoo.d201119.t02;

import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		String s = "()()";
		String s1 = "(())()";
		String s2 = ")()(";
		String s3 = "(()(";
		
		System.out.println(solution(s));
		System.out.println(solution(s1));
		System.out.println(solution(s2));
		System.out.println(solution(s3));
		
		
	}
	
	    static boolean solution(String s) {
	        boolean answer = true;
	        Stack<Character> stack = new Stack<>();

	        for(int i=0; i < s.length(); i++){
	                if(s.charAt(i) == '(')  // '('면 스택에 삽입
	                    stack.push(s.charAt(i));
	                
	                else {
	                    if(stack.isEmpty()) 
	                    	return false; // ')'인 경우에 스택이 비어있으면-> false
	                    else
	                        stack.pop();    // 안비어있으면 꺼냄 -> pop
	                    }
	              }
	        
	        answer = (stack.isEmpty()) ? true : false;

	        return answer;
	    }
}





