package study.eunwoo.SWEA;

import java.util.Scanner;

public class S2007 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int test=0; test<T; test++) {
            String str = sc.next();

            for (int i=1; i<=str.length(); i++) {
                String pattern = str.substring(0, i);
                String temp = str.substring(i, i+i);

                if (pattern.equals(temp)) {
                    System.out.println("#"+(test+1)+" "+pattern.length());
                    break;
                }
            }
        }
    }
}
