package baekjoon;

import java.util.Scanner;

public class Baekjoon6749 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		int ageOne = scn.nextInt();
		int ageTwo = scn.nextInt();
		
		int ageSub = ageTwo - ageOne;
		
		System.out.println(ageTwo + ageSub);
	}
}
