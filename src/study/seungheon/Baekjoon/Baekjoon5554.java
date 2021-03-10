package baekjoon;

import java.util.Scanner;

public class Baekjoon5554 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		int homeToSchool = scn.nextInt();
		int schoolToPC = scn.nextInt();
		int PCToAcmy = scn.nextInt();
		int acmyToHome = scn.nextInt();
		
		int sum = homeToSchool+schoolToPC+PCToAcmy+acmyToHome;
		
		System.out.println(sum/60);
		System.out.println(sum%60);
	}
}
