package study.eunwoo.SWEA;

import java.util.Scanner;

// [1284 수도 요금 경쟁] https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV189xUaI8UCFAZN&categoryId=AV189xUaI8UCFAZN&categoryType=CODE
public class S1284 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int test=1; test<=T; test++) {
            int P = sc.nextInt(); // A사의 1리터당 요금
            int Q = sc.nextInt(); // B사의 기본 요금
            int R = sc.nextInt(); // B사의 요금이 추가되는 기준
            int S = sc.nextInt(); // B사의 1리터당 추가되는 요금
            int W = sc.nextInt(); // 종민이가 쓴 물의 양

            int resultB = Q;
            int resultA = P * W;

            if (W > R) {
                resultB += (W - R) * S;
            }

            System.out.println("#"+test+" "+Math.min(resultA, resultB));
        }
    }
}
