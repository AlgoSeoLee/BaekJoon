package study.yoo.m2010.d201029.t01;

import java.util.Scanner;

//https://www.acmicpc.net/problem/1110
public class Main {
 
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
 
		int n = in.nextInt();
		in.close();
        
		int count = 0;
		int copy = n;
        
		while (true) {
			n = ((n % 10) * 10) + (((n / 10) + (n % 10)) % 10);
			count++;
 
			if (copy == n) {
				break;
			}
		}
		System.out.println(count);
	}
}
