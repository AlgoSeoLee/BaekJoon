package study.eunwoo.SWEA;

import java.util.Scanner;

// [10200 구독자 전쟁] https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXMCXV_qVgkDFAWv&categoryId=AXMCXV_qVgkDFAWv&categoryType=CODE
public class S10200 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int test=1; test<=T; test++) {
            int N = sc.nextInt();

            int A = sc.nextInt();
            int B = sc.nextInt();

            int max = Math.min(A, B);
            int min = (A+B) - N;

            if (min < 0) min = 0;

            System.out.println("#"+test+" "+max+" "+min);
        }
    }
}
