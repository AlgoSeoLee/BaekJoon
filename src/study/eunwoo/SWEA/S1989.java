package study.eunwoo.SWEA;

import java.util.Scanner;

// [1989 초심자의 회문 검사] https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PyTLqAf4DFAUq&categoryId=AV5PyTLqAf4DFAUq&categoryType=CODE
public class S1989 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int test=0; test<T; test++) {
            String str = sc.next();
            String reverseStr = (new StringBuffer(str)).reverse().toString();

            if (str.equals(reverseStr)) {
                System.out.println("#"+(test+1)+" "+1);
            } else {
                System.out.println("#"+(test+1)+" "+0);
            }
        }
    }
}
