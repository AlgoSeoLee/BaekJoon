package study.yoo.m2011.d201116.t01;

public class Main {

	public static void main(String[] args) {
		int[] numbers = {1, 1, 1, 1, 1};
		int target = 3;
		System.out.println(solution(numbers, target));
	}

	
	    public static int solution(int[] numbers, int target) {
	        int answer = 0;
	        answer = dfs(numbers, 0, 0, target);
	        return answer;
	    }
	    
	    static int dfs(int[] numbers, int index, int sum, int target){
	        if(index == numbers.length){
	            if(sum == target)
	                return 1;
	            return 0;
	        }
	        //재귀 (놀라와,,)
	        return dfs(numbers, index+1, sum + numbers[index], target) 
	        	 + dfs(numbers, index+1, sum - numbers[index], target);
	    }
	    

}
