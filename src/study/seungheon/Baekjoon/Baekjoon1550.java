package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek1550 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String hex = br.readLine();
		
		System.out.println(Integer.parseInt(hex, 16));
	}
}
