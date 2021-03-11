package baekjoon;

import java.math.BigInteger;
import java.util.Scanner;

public class Baekjoon11382 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		BigInteger numOne = scn.nextBigInteger();
		BigInteger numTwo = scn.nextBigInteger();
		BigInteger numThree = scn.nextBigInteger();
		
		System.out.println(numOne.add(numTwo).add(numThree));
	}
}