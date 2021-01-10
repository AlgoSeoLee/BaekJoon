package study.eunwoo.SWEA;

import java.util.Scanner;

// [1970 쉬운 거스름돈] https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PsIl6AXIDFAUq&categoryId=AV5PsIl6AXIDFAUq&categoryType=CODE
public class S1970 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] money = { 50000, 10000, 5000, 1000, 500, 100, 50, 10 };

        int T = sc.nextInt();
        for (int test=0; test<T; test++) {
            int N = sc.nextInt();
            int [] answers = new int[8];

            int temp = N;
            for (int i=0; i<money.length; i++) {
                if (money[i] <= temp) {
                    answers[i] = temp / money[i];
                    temp %= money[i];
                }

                if (temp == 0) break;
            }

            System.out.println("#"+(test+1));
            for (int ans: answers) {
                System.out.format("%d ", ans);
            }
            System.out.println();
        }
    }
}

