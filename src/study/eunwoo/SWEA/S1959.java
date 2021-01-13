package study.eunwoo.SWEA;

import java.util.Scanner;

// <발표> [1959 두 개의 숫자열] https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PpoFaAS4DFAUq&categoryId=AV5PpoFaAS4DFAUq&categoryType=CODE
public class S1959 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int test=1; test<=T; test++) {
            int N = sc.nextInt(); // 배열 A 길이
            int M = sc.nextInt(); // 배열 B 길이

            int [] arrA = new int[N];
            int [] arrB = new int[M];

            for (int i=0; i<N; i++) arrA[i] = sc.nextInt();
            for (int i=0; i<M; i++) arrB[i] = sc.nextInt();

            int max = 0;
            if (N < M) {
                for (int i=0; i<=M-N; i++) { // i=0, 1, 2
                    int sum = 0;

                    for (int j=0; j<N; j++) { // j=0, 1, 2
                        sum += arrA[j] * arrB[i+j];
                    }

                    max = Math.max(sum, max);
                }
            } else {
                for (int i=0; i<=N-M; i++) {
                    int sum = 0;

                    for (int j=0; j<M; j++) {
                        sum += arrA[i+j] * arrB[j];
                    }

                    max = Math.max(sum, max);
                }
            }

            System.out.format("#%d %d", test, max);
            System.out.println();
        }
    }
}
