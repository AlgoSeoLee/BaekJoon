package study.yoo.m2010.d201026.t02;

import java.util.Scanner;

//https://www.acmicpc.net/problem/2839
public class Main {

	public static void main(String[] args) {
		
	        Scanner sc = new Scanner(System.in);
	        int n = sc.nextInt();
	        int count = 0;
	        
	        while(true) {
	            if (n % 5 ==0) {
	                System.out.println(n/5 + count);
	                break;
	            }else if(n <= 0) {
	                System.out.println(-1);
	                break;
	            }
	            n = n-3;
	            count++;
	        }

		
		
	}

}
