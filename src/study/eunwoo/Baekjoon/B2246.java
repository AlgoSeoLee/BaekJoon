package study.eunwoo.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// [2246 콘도 선정] https://www.acmicpc.net/problem/2246
public class B2246 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] condo = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 2; j++) {
                condo[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(condo, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });

        int temp = condo[0][1];

        int count = 1;

        for (int i = 1; i < n; i++) {
            if (temp > condo[i][1]) {
                temp = condo[i][1];
                count++;
            }
        }

        System.out.println(count);
    }
}

