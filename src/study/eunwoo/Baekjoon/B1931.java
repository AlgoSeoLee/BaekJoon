package study.eunwoo.Baekjoon;

import java.io.IOException;
import java.util.*;

// [백준 1931 회의실 배정] https://www.acmicpc.net/problem/1931
public class B1931 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int [][] times = new int[N][2];

        for (int i=0; i<N; i++) {
            for (int j=0; j<2; j++) {
                times[i][j] = sc.nextInt();
            }
        }

        Arrays.sort(times, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });

        int count = 0;
        int end = -1;

        for (int i=0; i<N; i++) {
            if (times[i][0] >= end) {
                end = times[i][1];
                count++;
            }
        }

        System.out.println(count);
    }
}
