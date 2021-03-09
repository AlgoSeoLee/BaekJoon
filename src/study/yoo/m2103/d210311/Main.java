package study.yoo.m2103.d210311;

import java.util.Scanner;


//서버실
//미완성,,
public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[][] arr = new long[N][N];
		long max = 0;
		
        for (int i = 0; i < N; i++) {
        	for(int j = 0; j < N; j++) {
        		arr[i][j] = sc.nextLong();
        		max = Math.max(max, arr[i][j]);
        	}
        }
	
        long left = 1;   
        long right = max;
        
        while (left <= right) {
            long mid = (left + right) / 2; 
            long sum = 0;
            
            for (int i = 0; i < N; i++) { 
            	for(int j = 0; j < N; j++) {
                sum += arr[i][j] <= mid ? arr[i][j] : mid;
            	}
            }
            
            if (sum >= N) { 
                right = mid - 1;
            } else { 
                left = mid + 1;
            }
        }
        
        System.out.println(right);
	
	
	
	
	}

}
