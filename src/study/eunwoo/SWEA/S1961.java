package study.eunwoo.SWEA;

import java.util.Scanner;

// [1961 숫자 배열 회전] https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5Pq-OKAVYDFAUq&categoryId=AV5Pq-OKAVYDFAUq&categoryType=CODE
public class S1961 {
    static int N;

    static int[][] rotate(int [][] arr) {
        int c = 0;
        int [][] rotateArr = new int[N][N];

        for (int j=0; j<N; j++) {
            for (int i=N-1; i>=0; i--) {
                rotateArr[j][c%N] = arr[i][j];
                c++;
            }
        }

        return rotateArr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int test=1; test<=T; test++) {
            N = sc.nextInt();
            int [][] arr = new int[N][N];
            int [][] arr90, arr180, arr270;

            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            arr90 = rotate(arr);
            arr180 = rotate(arr90);
            arr270 = rotate(arr180);

            System.out.println("#"+test);
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    System.out.print(arr90[i][j]);

                }
                System.out.print(" ");

                for (int j=0; j<N; j++) {
                    System.out.print(arr180[i][j]);

                }
                System.out.print(" ");

                for (int j=0; j<N; j++) {
                    System.out.print(arr270[i][j]);

                }
                System.out.println();
            }
        }
    }
}
