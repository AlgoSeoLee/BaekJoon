package study.eunwoo.SWEA;

import java.util.Scanner;

// [10032 과자 분배] https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXJZ6_6KCLcDFAU3&categoryId=AXJZ6_6KCLcDFAU3&categoryType=CODE
public class S10032 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int test=1; test<=T; test++) {
            int N = sc.nextInt();
            int K = sc.nextInt();

            if (N % K == 0) {
                System.out.println("#"+test+" 0");
            } else {
                System.out.println("#"+test+" 1");
            }
        }
    }
}
