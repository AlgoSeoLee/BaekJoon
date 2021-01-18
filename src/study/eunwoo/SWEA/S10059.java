package study.eunwoo.SWEA;

import java.util.Scanner;

// [10059 유효기간] https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXK6YRNaKq0DFAU3
public class S10059 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int test=1; test<=T; test++) {
            String valid = sc.next();

            int a = Integer.parseInt(valid.substring(0, 2));
            int b = Integer.parseInt(valid.substring(2, 4));

            System.out.print("#"+test+" ");
            if((a > 12 && b == 0) || (a == 0 && b == 0) || (a > 12 && b > 12) || (a == 0 && b > 12)) {
                System.out.println("NA");
            } else if(a > 12 || a == 0) {
                System.out.println("YYMM");
            } else if(b > 12 || b == 0) {
                System.out.println("MMYY");
            } else {
                System.out.println("AMBIGUOUS");
            }
        }
    }
}
