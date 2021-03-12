package baekjoon;

import java.util.Scanner;

public class Baekjoon17256 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		int ax = scn.nextInt();
		int ay = scn.nextInt();
		int az = scn.nextInt();
		
		int cx = scn.nextInt();
		int cy = scn.nextInt();
		int cz = scn.nextInt();
		
		System.out.println((cx-az) + " " + (cy/ay) + " " + (cz-ax));
	}
}