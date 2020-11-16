package study.yoo.d201116.t02;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
	
		for(int i = 0; i < solution(array, commands).length; i++)
			System.out.print(solution(array, commands)[i] + " ");
		
	}

	    public static int[] solution(int[] array, int[][] commands) {
	        int[] answer = new int[commands.length]; //배열 길이 지정 안해주면 에러남
	        
	        for(int i = 0; i < commands.length; i++){ 
	            int temp[] = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]); //문자열은 slice() 함수 사용, int 배열은 copy해서 씀
	            Arrays.sort(temp);
	            answer[i] = temp[commands[i][2]-1]; 
	        }

	        return answer;
	    }

	    
}
