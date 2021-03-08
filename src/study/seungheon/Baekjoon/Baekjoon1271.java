package baekjoon;

import java.math.BigInteger;
import java.util.Scanner;

public class Baek1271 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		BigInteger N = scn.nextBigInteger();
		BigInteger M = scn.nextBigInteger();
		
		BigInteger div = new BigInteger("0");
		BigInteger ext = new BigInteger("0");
		
		div = N.divide(M);
		ext = N.mod(M);
		
		System.out.println(div);
		System.out.println(ext);
	}
}
