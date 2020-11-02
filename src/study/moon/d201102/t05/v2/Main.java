package study.moon.d201102.t05.v2;

import java.util.Scanner;

public class Main {

    public static int n;
    public static int count;
    public static int[] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            map = new int[n + 1];
            map[1] = i;
            dfs(map, 1);
        }
        System.out.println(count);
    }

    public static boolean check(int[] map, int col) {
        for (int i = 1; i < col; i++) {
            if (map[i] == map[col]) {
                return false;
            }
            if (Math.abs(i - col) == Math.abs(map[i] - map[col])){
                return false;
            }
        }
        return true;

    }

    public static void dfs(int[] map, int col) {
        if (col == n) {
            count++;
        } else {
            for (int i = 1; i <= n; i++) {
                map[col + 1] = i;
                if (check(map, col + 1)) {
                    dfs(map, col + 1);
                }
            }
        }
    }
}
