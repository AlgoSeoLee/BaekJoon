package study.eunwoo.SWEA;

import java.util.Scanner;

// [1984 중간 평균값 구하기] https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5Pw_-KAdcDFAUq&categoryId=AV5Pw_-KAdcDFAUq&categoryType=CODE
public class S1984 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int test=0; test<T; test++) {
            int min = 10000;
            int max = 0;
            int sum = 0;

            for (int i=0; i<10; i++) {
                int n = sc.nextInt();
                sum += n;

                if (n < min) min = n;
                if (n > max) max = n;
            }

            System.out.format("#%d %d\n", test+1, Math.round((sum - (max + min))/8.0));
        }
    }
}
