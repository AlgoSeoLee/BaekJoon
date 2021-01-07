package study.eunwoo.SWEA;

import java.util.Scanner;

public class S1974 {
    static int [][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int test=0; test<T; test++) {
            map = new int[9][9];

            for (int i=0; i<9; i++) {
                for (int j=0; j<9; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            boolean flag = true;

            // 가로 검사
            for (int i=0; i<9; i++) {
                if (!checkGaro(i)) {
                    System.out.println("#"+(test+1)+" "+0);
                    flag = false;
                    break;
                }
            }
            if (!flag) continue;

            // 세로 검사
            for (int j=0; j<9; j++) {
                if (!checkSero(j)) {
                    System.out.println("#"+(test+1)+" "+0);
                    flag = false;
                    break;
                }
            }
            if (!flag) continue;

            // 3x3 격자 검사
            for (int i=0; i<=6; i+=3) {
                for (int j=0; j<=6; j+=3) {
                    if (!checkGrid(i, j)) {
                        System.out.println("#"+(test+1)+" "+0);
                        flag = false;
                        break;
                    }
                }
                if (!flag) break;
            }
            if (!flag) continue;

            System.out.println("#"+(test+1)+" "+1);
        }
    }

    public static boolean checkGaro(int x) {
        boolean [] check = new boolean[9];

        for (int j=0; j<9; j++) {
            if (check[map[x][j] - 1])
                return false;

            check[map[x][j] - 1] = true;
        }

        return true;
    }

    public static boolean checkSero(int y) {
        boolean [] check = new boolean[9];

        for (int i=0; i<9; i++) {
            if (check[map[i][y] - 1])
                return false;

            check[map[i][y] - 1] = true;
        }

        return true;
    }

    public static boolean checkGrid(int x, int y) {
        boolean [] check = new boolean[9];

        int nx = x + 3;
        int ny = y + 3;

        for (int i=x; i<nx; i++) {
            for (int j=y; j<ny; j++) {
                if (check[map[i][j] - 1])
                    return false;

                check[map[i][j] - 1] = true;
            }
        }

        return true;
    }
}
