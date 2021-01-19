package study.eunwoo.SWEA;

import java.util.Scanner;

// [10580 전봇대] https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXO8QBw6Qu4DFAXS&categoryId=AXO8QBw6Qu4DFAXS&categoryType=CODE
public class S10580 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int test=1; test<=T; test++) {
            int N = sc.nextInt();
            int [][] point = new int[N][2]; // 전선 입력할 배열

            for (int i=0; i<N; i++) {
                for (int j=0; j<2; j++) {
                    point[i][j] = sc.nextInt();
                }
            }

            int crossPoint = 0; // 교차점

            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    if (i == j) continue;

                    if (point[i][0] < point[j][0] && point[i][1] > point[j][1]) {
                        crossPoint++;
                    } else if (point[i][0] > point[j][0] && point[i][1] < point[j][1]) {
                        crossPoint++;
                    }
                }
            }

            System.out.println("#"+test+" "+crossPoint/2);
        }
    }
}
