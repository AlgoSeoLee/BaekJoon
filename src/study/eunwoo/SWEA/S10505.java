package study.eunwoo.SWEA;

import java.util.Scanner;

// [10505 소득 불균형] https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXNP4CvauaMDFAXS&categoryId=AXNP4CvauaMDFAXS&categoryType=CODE
public class S10505 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int test=1; test<=T; test++) {
            int N = sc.nextInt();

            int [] arr = new int[N];
            int sum = 0; // 합
            int ave; // 평균
            int count = 0;

            for (int i=0; i<N; i++) {
                arr[i] = sc.nextInt();
                sum += arr[i];
            }

            ave = sum/N;

            for (int i = 0; i < N; i++) {
                if (ave >= arr[i]) count++;
            }

            System.out.println("#"+test+" "+count);

        }
    }
}
