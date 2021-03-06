package study.yoo.m2103.d210308.t02;

import java.util.Scanner;

// 백준 랜선자르기 1654
//https://www.acmicpc.net/problem/1654
public class Main {

	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        long N = sc.nextLong();
        long[] arr = new long[K];
        long max = 0;
        for (int i = 0; i < K; i++) {
            arr[i] = sc.nextLong();
            max = Math.max(max, arr[i]);
        }

        long left = 1; //랜선길이 자연수  
        long right = max;
        
        while (left <= right) {
            long mid = (left + right) / 2; //N개 만들 랜선 길이
            long sum = 0;
            
            for (int i = 0; i < K; i++) { // 랜선 자른 개수 합
                sum += (arr[i] / mid);
            }
            
            if (sum >= N) { //랜선이 N보다 많이나오면 크기 늘림
                left = mid + 1;
            } else { //랜선이 N보다 적게나오면 크기 줄임
                right = mid - 1;
            }
        }
        
        System.out.println(right);
	}

}
