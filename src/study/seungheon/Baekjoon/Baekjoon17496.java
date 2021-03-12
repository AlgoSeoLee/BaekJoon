package baekjoon;

import java.util.Scanner;

public class Baekjoon17496 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		int summer = scn.nextInt();
		int grow = scn.nextInt();
		int size = scn.nextInt();
		int price = scn.nextInt();
		
		int multi = 0;
		
		if (summer%grow == 0) {
			multi = summer/grow -1;
		} else {
			multi = summer/grow;
		}
		int count = multi*size;
		
		System.out.println(price*count);
	}
}