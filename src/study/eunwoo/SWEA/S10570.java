package study.eunwoo.SWEA;

import java.util.Scanner;

// [10570 제곱 팰린드롬 수] https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXO72aaqPrcDFAXS
public class S10570 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int test = 1; test <= T; test++) {
            int A = sc.nextInt();
            int B = sc.nextInt();

            int count = 0;

            for (int i = A; i <= B; i++) {
                boolean check = isPalindrome(String.valueOf(i)); // 먼저 회문을 찾음
                if(check) { // 회문이 맞다면,
                    double sqrt = Math.sqrt(i); // 그 수에 대한 제곱근을 찾는다
                    if(i % sqrt == 0) { // 회문인 수와 제곱근이 나누어떨어질 때
                        if(isPalindrome(String.valueOf((int) sqrt))) // 제곱근에 대한 회문 검사
                            count++;
                    }
                }
            }

            System.out.println("#" + test + " " + count);
        }
    }

    static boolean isPalindrome(String str) {
        int size = str.length();

        for (int i = 0; i < size / 2; i++) {
            if (str.charAt(i) != str.charAt(size - i - 1))
                return false;
        }
        return true;
    }
}
