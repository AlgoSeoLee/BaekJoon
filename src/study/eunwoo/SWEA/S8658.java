package study.eunwoo.SWEA;

import java.util.Scanner;

public class S8658 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int test=1; test<=t; test++) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;

            for (int i = 0; i < 10; i++) {
                int num = sc.nextInt();
                int sum = 0;

                while (num > 0) {
                    int digit = num % 10;
                    num /= 10;

                    sum += digit;
                }

                max = Math.max(max, sum);
                min = Math.min(min, sum);
            }

            System.out.println("#"+test+" "+max+" "+min);
        }
    }
}
