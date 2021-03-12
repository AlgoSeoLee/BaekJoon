package baekjoon;

import java.util.Scanner;

public class Baekjoon20492 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		int num = scn.nextInt();
		
		float resultOne = (float)(num*0.78);
		float resultTwo = (float)(num-num*(0.2*0.22));
		
		
		System.out.printf("%.0f %.0f", resultOne, resultTwo);
	}
}