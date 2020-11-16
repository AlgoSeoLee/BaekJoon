package study.yoo.d201116.t03;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {

		int[] citations = {3, 0, 6, 1, 5};
		System.out.println(solution(citations));
	}

	

	    public static int solution(int[] citations) {
	        int answer = 0;
	        int more = 0;
	        int h = 0;

	        Arrays.sort(citations);
	        for(int i = 0; i < citations.length; i++){
	            h = citations[i];
	            more =  citations.length - i;
	            if (more <= h) {
	                answer = more;
	                break;
	            }
	        }
	        return answer;
	    }


}




//class Solution {
//    public int solution(int[] citations) {
//        int answer = 0;
//        int highCount = 0;
//        int lowCount = 0;
//
//        
//        for(int i = 0; i < citations.length; i++){
//            int h = citations[i];
//            if(h <= citations[i])
//                highCount ++;
//            else if(h >= citations[i])
//                lowCount ++;
//            
//            if(h == highCount && h == lowCount)
//                answer = h;
//        }
//        return answer;
//    }
//}