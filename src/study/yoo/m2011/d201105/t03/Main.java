package study.yoo.m2011.d201105.t03;

import java.util.Scanner;

//https://www.acmicpc.net/problem/14405
//런타임에러,,ㅋ
public class Main {

	public static void main(String[] args) {

		String[] a = {"pi", "ka", "chu"};
		
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		sc.close();
		int length = s.length();
		
		for(int i =0; i<length; i++) {
			boolean B = false;
			
			for(int j = 0; j<3; j++) {
				if(i + a[j].length() > length)
					continue;
				String tmp = s.substring(i, i + a[j].length());
				
				if(tmp.equals(a[j])) {
					i += tmp.length() -1;
					B = true;
					continue;
				}
			}
			if(!B) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}
	
}
