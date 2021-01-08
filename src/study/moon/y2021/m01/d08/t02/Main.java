package study.moon.y2021.m01.d08.t02;

import java.util.Arrays;
import java.util.Scanner;

//https://www.acmicpc.net/problem/15666    [S2]    N과M(12)
public class Main {

    private static int n, m;
    private static int[] map;
    private static int[] result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n];
        result = new int[m];

        for (int i = 0; i < n; i++) {
            map[i] = sc.nextInt();
        }
        Arrays.sort(map);

        StringBuilder sb = new StringBuilder();

        cycle(0, 0, sb);

        System.out.print(sb);

    }

    private static void cycle(int start, int cnt, StringBuilder sb) {
        if (cnt == m) {
            for (int i = 0; i < m; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");

        } else {
            int num = 0;
            for (int i = start; i < n; i++) {
                if (num == map[i]) {
                    continue;
                }
                result[cnt] = map[i];
                cycle(i, cnt + 1, sb);
                num = map[i];
            }
        }

    }

}
