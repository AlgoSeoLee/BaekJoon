package study.eunwoo.SWEA;

import java.util.Scanner;

// [1948 날짜 계산기] https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PnnU6AOsDFAUq&categoryId=AV5PnnU6AOsDFAUq&categoryType=CODE
public class S1948 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int [] days = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        int T = sc.nextInt();
        for (int test=1; test<=T; test++) {
            int firstMonth = sc.nextInt();
            int firstDay = sc.nextInt();
            int lastMonth = sc.nextInt();
            int lastDay = sc.nextInt();

            int answer = 0;

            if (firstMonth == lastMonth) {
                answer = lastDay - firstDay + 1;
                System.out.println("#"+ test + " " + answer);
                continue;
            }

            for (int i=firstMonth; i<lastMonth; i++) { //5, 6, 7
                answer += days[i];
            }

            answer += lastDay - firstDay + 1;
            System.out.println("#"+ test + " " + answer);
        }
    }
}
