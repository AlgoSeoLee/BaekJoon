package study.eunwoo.SWEA;

import java.util.Scanner;

public class S2005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int test=0; test<T; test++) {
            int N = sc.nextInt();
            int [][] triangle = new int[N][N];
            triangle[0][0] = 1;

            for (int i=1; i<N; i++) {
                for (int j=0; j<=i; j++) {
                    if (i == j || j == 0) {
                        triangle[i][j] = 1;
                    } else {
                        triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
                    }
                }
            }

            System.out.println("#"+(test+1));
            for (int x=0; x<N; x++) {
                for (int y=0; y<=x; y++) {
                    System.out.print(triangle[x][y] + " ");
                }
                System.out.println();
            }
        }
    }
}
