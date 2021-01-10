package study.eunwoo.SWEA;

import java.util.Scanner;

// [1986 지그재그 숫자] https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PxmBqAe8DFAUq&categoryId=AV5PxmBqAe8DFAUq&categoryType=CODE
public class S1986 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int test=0; test<T; test++) {
            int N = sc.nextInt();

            int sum = 0;
            for (int i=1; i<=N; i++) {
                if (i % 2 == 0) {
                    sum -= i;
                } else {
                    sum += i;
                }
            }

            System.out.println("#"+(test+1)+" "+sum);
        }
    }
}
