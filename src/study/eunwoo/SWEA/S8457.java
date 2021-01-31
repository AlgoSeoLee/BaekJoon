package study.eunwoo.SWEA;

import java.util.Scanner;

// [8457. 알 덴테 스파게티] https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AWzal4EKksEDFAVU&categoryId=AWzal4EKksEDFAVU&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=JAVA&select-1=3&pageSize=10&pageIndex=4
public class S8457 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int test=1; test<=t; test++) {
            int n = sc.nextInt();
            int b = sc.nextInt();
            int e = sc.nextInt();

            int [] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int count = 0;

            for (int i = 0; i < n; i++) {
                for (int j = b - e; j <= b + e; j++) {
                    if (j % arr[i] == 0) {
                        count++;
                        break;
                    }
                }
            }

            System.out.println("#"+test+" "+count);
        }
    }
}
