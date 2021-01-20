package study.eunwoo.SWEA;

import java.util.Scanner;

// [9839 최고의 쌍] https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXGBGehqPAADFAXR&categoryId=AXGBGehqPAADFAXR&categoryType=CODE
public class S9839 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int test=1; test<=T; test++) {
            int N = sc.nextInt();
            int [] arr = new int[N];
            int result = -1;

            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }

            for (int i=0; i<N; i++) {
                for (int j=i+1; j<N; j++) {
                    int num = arr[i] * arr[j];

                    int tmp = num % 10;
                    boolean flag = true;

                    num /= 10;

                    while (num > 0) {
                        if (tmp - 1 == num % 10) {
                            tmp--;
                        } else {
                            flag = false;
                            break;
                        }
                        num /= 10;
                    }

                    if (flag && result < arr[i] * arr[j]) {
                        result = arr[i] * arr[j];
                    }
                }
            }
            System.out.println("#"+test+" "+result);
        }
    }
}
