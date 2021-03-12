package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Baekjoon14652 {

	public static void main(String[] args) throws Exception {
		Scanner scn = new Scanner(System.in);
		
		int height = scn.nextInt();
		int weight = scn.nextInt();
		
		int K = scn.nextInt();
		
		int xPosition = K/weight;
		int yPosition = K-xPosition*weight;
		
		System.out.println(xPosition +" "+ yPosition);
	}
}