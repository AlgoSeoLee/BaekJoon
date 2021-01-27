package study.eunwoo.SWEA;

import java.util.Arrays;
import java.util.Scanner;

// [1966 숫자를 정렬하자] https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PrmyKAWEDFAUq&categoryId=AV5PrmyKAWEDFAUq&categoryType=CODE
public class S1966 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int test=0; test<T; test++) {
            int N = sc.nextInt();
            int [] arr = new int[N];

            for (int i=0; i<N; i++) {
                arr[i] = sc.nextInt();
            }

            Arrays.sort(arr);
            System.out.print("#"+(test+1)+" ");
            for (int a: arr) {
                System.out.format("%d ", a);
            }
            System.out.println();
        }
    }
}
