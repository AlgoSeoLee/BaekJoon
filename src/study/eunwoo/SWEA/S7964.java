package study.eunwoo.SWEA;

import java.util.Scanner;

// [7964. 부먹왕국의 차원 관문] https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWuSgKpqmooDFASy
public class S7964 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int test=1; test<=t; test++) {
            int n = sc.nextInt();
            int d = sc.nextInt();

            int [] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int count = 0;

            for (int i = 0, dis = 0; i < n; i++, dis++) {
                if (i == 0 && arr[i] == 0) {
                    count++;
                    System.out.println(arr[i]);
                }
                else if (arr[i] == 1)
                    dis = 0;
                else if (dis == d) {
                    if (arr[i] == 0) {
                        count++;
                    }
                    dis = 0;
                }
            }

            System.out.println("#"+test+" "+count);
        }
    }
}
