package study.yoo.d201102.t02;

import java.util.Arrays;
import java.util.Scanner;

//https://www.acmicpc.net/problem/2309
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int [] arr = new int[9];
		boolean check = false;
		int sum =0;
		for(int i=0; i<9; i++) {
			int a = sc.nextInt();
			arr[i] = a;
			sum +=a;
			
		}
		
		for(int i=0; i<9; i++) {
			if(check) break;
			for(int j=0; j<9; j++) {
				if(i==j) {
					continue;
				}
				if(sum-arr[i]-arr[j]==100) {
					arr[i]=0;
					arr[j]=0;
					check = true;
					break;
				}
			}
		}
		Arrays.sort(arr);

		for(int i=0; i<9; i++) {
			if(arr[i]!=0) {
				System.out.println(arr[i]);
			}
		}

	}

}
