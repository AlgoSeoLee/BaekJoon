package study.eunwoo.SWEA;

import java.util.Scanner;

// [1940 가랏! RC카!] https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PjMgaALgDFAUq&categoryId=AV5PjMgaALgDFAUq&categoryType=CODE
public class S1940 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int test=1; test<=T; test++) {
            int N = sc.nextInt();

            int speed = 0;
            int distance = 0;

            for (int i=0; i<N; i++) {
                int cmd = sc.nextInt();

                if (cmd != 0) {
                    int accel = sc.nextInt();

                    if (cmd == 1) { // 가속 될 경우
                        speed += accel;

                    } else { // 감속 될 경우
                        if (speed < accel) {
                            speed = 0;

                        } else {
                            speed -= accel;
                        }
                    }
                }

                distance += speed;
            }

            System.out.println("#"+test+" "+distance);
        }
    }
}
