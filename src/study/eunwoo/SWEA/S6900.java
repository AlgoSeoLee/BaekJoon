package study.eunwoo.SWEA;

import java.util.Scanner;

// [6900. 주혁이의 복권 당첨] https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AWh4FhG6Ei4DFAXp&categoryId=AWh4FhG6Ei4DFAXp&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=3&pageSize=10&pageIndex=6
public class S6900 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int test=1; test<=t; test++) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            String [][] numbers = new String[n][2];
            String [] lottery = new String[m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 2; j++) {
                    numbers[i][j] = sc.next();
                }
            }

            for (int i = 0; i < m; i++) {
                lottery[i] = sc.next();
            }

            int money = 0;
            boolean flag;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {

                    flag = true;

                    for (int k = 0; k < 8; k++) {
                        char c = numbers[i][0].charAt(k);

                        if (c != lottery[j].charAt(k)) {
                            if (c != '*') {
                                flag = false;
                                break;
                            }
                        }
                    }

                    if (flag) money += Integer.parseInt(numbers[i][1]);
                }
            }

            System.out.println("#"+test+" "+money);
        }
    }
}
