package study.eunwoo.SWEA;

import java.util.Scanner;

// <발표> [1954 달팽이 숫자] https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PobmqAPoDFAUq&categoryId=AV5PobmqAPoDFAUq&categoryType=CODE#;return%20false;
public class S1954 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int test=1; test<=T; test++) {
            int N = sc.nextInt();

            int [][] map = new int[N][N];
            int x = 0;
            int y = -1;
            int turn = 1; // 증가, 감소 부분을 구분시킴
            int count = 1; // map에 들어갈 숫자 값

            while (true) {
                for (int i=0; i<N; i++) {
                    y += turn;
                    map[x][y] = count;
                    count++;
                }
                N--;

                for (int i=0; i<N; i++) {
                    x += turn;
                    map[x][y] = count;
                    count++;
                }
                turn *= -1;

                if (N == 0) {
                    break;
                }
            }

            System.out.println("#"+test);
            for (int i=0; i<map.length; i++) {
                for (int j=0; j<map.length; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
