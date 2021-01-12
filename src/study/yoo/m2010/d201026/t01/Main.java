package study.yoo.m2010.d201026.t01;

import java.util.ArrayList;
import java.util.Scanner;

//https://www.acmicpc.net/problem/1158
public class Main {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		int tmp =0;
		
		ArrayList<Integer> array = new ArrayList<Integer>();
		ArrayList<Integer> josepus  = new ArrayList<Integer>();
		
		for(int i = 1; i <= n; i++) {
			array.add(i);
		}
		
		while(!array.isEmpty()) {
			tmp = (tmp+k-1) % array.size();
			josepus.add(array.remove(tmp));
		}
		
		System.out.print("<");
		for(int i = 0; i<josepus.size(); i++) {
			System.out.print(josepus.get(i));
			if(i != josepus.size()-1) {
				System.out.print("," + " ");
			}
		}
		
		System.out.print(">");
		
	}

}
