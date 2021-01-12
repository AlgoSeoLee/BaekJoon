package study.yoo.m2012.d201203.t02;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//https://www.acmicpc.net/problem/2164
public class Main {
	public static Queue<Integer> queue = new LinkedList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int i = 1; i <= N; i++) {
			queue.add(i);
		}
		
		for(int i = 0; i < N; i++) {
			if(queue.size() == 1) {
				System.out.println(queue.poll());
				break;
			}
			queue.poll();
			queue.add(queue.poll());
		}
	}
}