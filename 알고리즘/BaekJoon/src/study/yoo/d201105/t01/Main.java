package study.yoo.d201105.t01;

import java.util.Scanner;

//https://www.acmicpc.net/problem/10872
public class Main {
 
	public static void main(String[] args) {
 
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		
		int sum = factorial(N);
		System.out.println(sum);
		
	}
	
	public static int factorial(int N) {
		if(N <= 1) return 1;	
		return N * factorial(N - 1);		
	}
	
}