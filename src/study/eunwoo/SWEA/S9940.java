package study.eunwoo.SWEA;

import java.util.Arrays;
import java.util.Scanner;

// [9940 순열1] https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXHx23oq0REDFAXR&categoryId=AXHx23oq0REDFAXR&categoryType=CODE
public class S9940 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int test=1; test<=T; test++) {
            int N = sc.nextInt();
            int [] arr = new int[N];
            boolean check = false;

            for (int i=0; i<N; i++) {
                arr[i] = sc.nextInt();
            }

            Arrays.sort(arr);

            for (int i=0; i<N; i++) {
                if (arr[i] == i+1) {
                    check = true;
                } else {
                    check = false;
                    break;
                }
            }

            if (check) {
                System.out.println("#"+test+" Yes");
            } else {
                System.out.println("#"+test+" No");
            }
        }
    }
}
