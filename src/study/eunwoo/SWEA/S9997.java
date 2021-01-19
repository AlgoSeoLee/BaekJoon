package study.eunwoo.SWEA;

import java.util.Scanner;

// [9997 미니멀리즘 시계] https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXIvNBzKapEDFAXR&categoryId=AXIvNBzKapEDFAXR&categoryType=CODE
public class S9997 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int test=1; test<=T; test++) {
            int angle = sc.nextInt();
            int hour, minute;

            hour = angle / 30;
            if (hour == 12) hour = 0;

            minute = (angle % 30) * 2;

            System.out.format("#%d %d %d", test, hour, minute);
            System.out.println();
        }
    }
}
