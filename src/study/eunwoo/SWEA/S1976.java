package study.eunwoo.SWEA;

import java.util.Scanner;

public class S1976 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int test = 0; test < T; test++) {
            int firstHour = sc.nextInt();
            int firstMinute = sc.nextInt();

            int secondHour = sc.nextInt();
            int secondMinute = sc.nextInt();

            int hours = 0;
            int minutes = 0;

            hours = firstHour + secondHour;
            minutes = firstMinute + secondMinute;

            if (hours > 12)
                hours -= 12;

            if (minutes > 59) {
                minutes -= 60;
                hours++;
            }

            System.out.format("#%d %d %d", test+1, hours, minutes);
            System.out.println();
        }
    }
}
