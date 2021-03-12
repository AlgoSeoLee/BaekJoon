package baekjoon;

import java.util.Scanner;

public class Baekjoon15727 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		int length = scn.nextInt();
		int time = length/5;
		
		if ( length%5 == 0 ) {
			System.out.println(time);
		} else {
			System.out.println(time+1);
		}
	}
}