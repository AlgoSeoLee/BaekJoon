package baekjoon;

import java.math.BigInteger;
import java.util.Scanner;

public class Baekjoon13277 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		BigInteger numOne = scn.nextBigInteger();
		BigInteger numTwo = scn.nextBigInteger();
		
		System.out.println(numOne.multiply(numTwo));
	}
}