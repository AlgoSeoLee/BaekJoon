package study.moon.d201208.t01;

import java.util.Scanner;

//https://www.acmicpc.net/problem/2775
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[15][15];
        for (int i = 0; i < 15; i++) {
            arr[0][i] = i;
        }
        for (int i = 1; i < 15; i++) {
            int count = 0;
            for (int j = 0; j < 15; j++) {
                count += arr[i-1][j];
                arr[i][j] = count;
            }
        }

        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int k = sc.nextInt();
            int n = sc.nextInt();
            System.out.println(arr[k][n]);
        }
    }
}
