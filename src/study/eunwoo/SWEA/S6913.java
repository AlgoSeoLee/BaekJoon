package study.eunwoo.SWEA;

import java.util.Scanner;

// [6913. 동철이의 프로그래밍 대회] https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWicMVWKTuMDFAUL
public class S6913 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int test=1; test<=t; test++) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int [][] map = new int[n][m];
            int [] problem = new int[n];

            int max = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    map[i][j] = sc.nextInt();

                    if (map[i][j] == 1) {
                        problem[i]++;
                    }
                }

                if (max < problem[i]) max = problem[i];
            }

            int count = 0;

            for (int i = 0; i < n; i++) {
                if (problem[i] == max) count++;
            }

            System.out.println("#"+test+" "+count+" "+max);
        }
    }
}
