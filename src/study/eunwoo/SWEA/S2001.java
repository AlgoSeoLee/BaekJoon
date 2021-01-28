package study.eunwoo.SWEA;

import java.util.Scanner;

// [2001 파리 퇴치] https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PzOCKAigDFAUq&categoryId=AV5PzOCKAigDFAUq&categoryType=CODE
public class S2001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int test=0; test<T; test++) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            int [][] array = new int[N][N];
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    array[i][j] = sc.nextInt();
                }
            }

            int sum, max = 0;
            for (int x=0; x<=N-M; x++) {
                for (int y=0; y<=N-M; y++) {
                    sum = 0;
                    for (int a=0; a<M; a++) {
                        for (int b=0; b<M; b++) {
                            sum += array[x+a][y+b];

                            if (sum > max) max = sum;
                        }
                    }
                }
            }

            System.out.println("#"+(test+1)+" "+max);
        }
    }
}
