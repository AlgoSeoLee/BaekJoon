package study.eunwoo.SWEA;

import java.util.Scanner;

public class S1979 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int test=0; test<T; test++) {
            int N = sc.nextInt(); // 가로, 세로 길이
            int K = sc.nextInt(); // 단어 길이
            int [][] map = new int[N][N];

            int words = 0; // 유효한 단어 수

            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            for (int i=0; i<N; i++) { // 가로 검사
                int count = 0;

                for (int j=0; j<N; j++) {
                    if (map[i][j] == 0) {
                        if (count == K) {
                            words++;
                        }
                        count = 0;

                    } else {
                        count++;
                    }
                }

                if (count == K) {
                    words++;
                }
            }

            for (int j=0; j<N; j++) { // 세로 검사
                int count = 0;

                for (int i=0; i<N; i++) {
                    if (map[i][j] == 0) {
                        if (count == K) {
                            words++;
                        }
                        count = 0;

                    } else {
                        count++;
                    }
                }

                if (count == K) {
                    words++;
                }
            }

            System.out.format("#%d %d\n", test+1, words);
        }
    }
}
