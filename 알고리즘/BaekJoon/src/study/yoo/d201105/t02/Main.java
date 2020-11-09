package study.yoo.d201105.t02;

import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

//https://www.acmicpc.net/problem/11729
public class Main {
 
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
 
		int N = sc.nextInt();
		
		//총 옮긴 횟수
		bw.write((int) (Math.pow(2, N) - 1) + "\n");
 
		Hanoi(N, 1, 2, 3);
		bw.flush();
		bw.close();
 
	}
 
	public static void Hanoi(int N, int start, int mid, int to) throws IOException {

		if (N == 1) {
			bw.write(start + " " + to + "\n");
			return;
		}
		// STEP 1 : N-1개를 A에서 B로 이동
		Hanoi(N - 1, start, to, mid);
		
		// STEP 2 : 1개를 A에서 C로 이동
		bw.write(start + " " + to + "\n");
		
		// STEP 3 : N-1개를 B에서 C로 이동
		Hanoi(N - 1, mid, start, to);
 
	}
}