package study.eunwoo.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [6808 규영이와 인영이의 카드게임] https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AWgv9va6HnkDFAW0&categoryId=AWgv9va6HnkDFAW0&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=3&pageSize=10&pageIndex=6
public class S6808 {
    private static final int [] turnA = new int[9];
    private static final int [] turnB = new int[9];
    private static int count, win, draw;
    private static boolean [] check;

    private static void dfs(int r, int sum1, int sum2) {
        if (r == 9) {
            count++;
            if (sum1 > sum2) win++;
            if (sum1 == sum2) draw++;
            return;
        }

        for (int i = 0; i < 9; i++) {
            if (!check[i]) {
                check[i] = true;
                if (turnA[r] > turnB[i]) {
                    dfs(r+1, sum1+turnA[r]+turnB[i], sum2);
                } else {
                    dfs(r+1, sum1, sum2+turnA[r]+turnB[i]);
                }
                check[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int test = 1; test <= t; test++) {
            count = win = draw = 0;
            boolean [] numeric = new boolean[19];
            check = new boolean[9];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 9; i++) {
                turnA[i] = Integer.parseInt(st.nextToken());
                numeric[turnA[i]] = true;
            }

            int temp = 0;

            for (int i = 1; i <= 18; i++) {
                if (!numeric[i]) {
                    turnB[temp++] = i;
                }
            }

            dfs(0, 0, 0);

            System.out.println("#"+test+" "+win+" "+(count-win-draw));
        }
    }
}
