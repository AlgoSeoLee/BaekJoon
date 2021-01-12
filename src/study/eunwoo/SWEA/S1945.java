package study.eunwoo.SWEA;

import java.io.IOException;
import java.util.Scanner;

// [1945 간단한 소인수분해] https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5Pl0Q6ANQDFAUq&categoryId=AV5Pl0Q6ANQDFAUq&categoryType=CODE
public class S1945 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int [] arr = { 2, 3, 5, 7, 11 };

        int T = sc.nextInt();

        for (int test=1; test<=T; test++) {
            int N = sc.nextInt();

            int [] pow = new int[arr.length];

            for (int i = 0; i < arr.length; i++) {
                while (N % arr[i] == 0) {
                    pow[i]++;
                    N /= arr[i];
                }
            }

            System.out.print("#"+test+" ");
            for(int p: pow) {
                System.out.print(p + " ");
            }
            System.out.println();
        }
    }
}
