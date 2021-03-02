package study.eunwoo.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// [1946 신입사원] https://www.acmicpc.net/problem/1946
public class B1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t != 0) {
            int n = Integer.parseInt(br.readLine());

            int [][] rank = new int[n][2];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                for (int j = 0; j < 2; j++) {
                    rank[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            Arrays.sort(rank, (o1, o2) -> {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            });

            int temp = rank[0][1];

            int count = 1;

            for (int i = 1; i < n; i++) {
                if (temp > rank[i][1]) {
                    temp = rank[i][1];
                    count++;
                }
            }

            System.out.println(count);

            t--;
        }
    }
}
