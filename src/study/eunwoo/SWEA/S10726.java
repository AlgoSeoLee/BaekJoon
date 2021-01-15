package study.eunwoo.SWEA;

import java.util.Scanner;

// [10726 이진수 표현] https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXRSXf_a9qsDFAXS&categoryId=AXRSXf_a9qsDFAXS&categoryType=CODE
public class S10726 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int test=1; test<=T; test++) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            boolean flag = false;

            for (int i=0; i<N; i++) {
                if ((1 & M) == 0) {
                    flag = true;
                    break;
                }

                M = M >> 1;
            }

            System.out.println("#"+test+" "+(flag ? "OFF" : "ON"));
        }
    }
}
