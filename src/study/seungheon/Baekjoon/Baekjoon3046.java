package baekjoon;

import java.util.Scanner;

public class Baekjoon3046 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		int R1, S;
		
		R1 = scn.nextInt();
		S = scn.nextInt();
		
		System.out.println(S*2 - R1);
	}

}
