package baekjoon;

import java.math.BigInteger;
import java.util.Scanner;

public class Baekjoon15964 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		BigInteger numOne = scn.nextBigInteger();
		BigInteger numTwo = scn.nextBigInteger();
		
		BigInteger firstResult = numOne.add(numTwo);
		BigInteger secondReslt = numOne.subtract(numTwo);
		
		System.out.println(firstResult.multiply(secondReslt));
	}
}