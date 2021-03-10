package baekjoon;

import java.math.BigInteger;
import java.util.Scanner;

public class Baekjoon8437 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		BigInteger apple = scn.nextBigInteger();
		BigInteger more = scn.nextBigInteger();
		
		BigInteger two = new BigInteger("2");
		
		System.out.println(apple.add(more).divide(two));
		System.out.println(apple.subtract(more).divide(two));
	}
}