package study.yoo.d201029.t02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//https://www.acmicpc.net/problem/1302
public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		ArrayList<String> books = new ArrayList<String>();
		ArrayList<String> res = new ArrayList<String>();
		
		int[] index = new int[1001];
		int max = 0;
		
		for(int i=0; i<n; i++) {
			String input = sc.next();
			if(!books.contains(input)) {
				
				books.add(input);
			}
			index[books.indexOf(input)]++;
			if(index[books.indexOf(input)]>max)
				max = index[books.indexOf(input)];
		}
		
		for(int i =0; i<n; i++) {
			if(index[i] == max) res.add(books.get(i));
		}
		
		Collections.sort(res);
		System.out.println(res.get(0));
	}

}
