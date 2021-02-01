package study.eunwoo.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [8104. 조 만들기] https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWwXCn2KQjEDFATu
public class S8104 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int test=1; test<=t; test++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int [][] arr = new int[n][k];
            int count = 1;

            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    for (int j = 0; j < k; j++) {
                        arr[i][j] = count++;
                    }
                } else {
                    for (int j = k - 1; j >= 0; j--) {
                        arr[i][j] = count++;
                    }
                }
            }

            int [] sum = new int[k];

            for (int i = 0; i < k; i++) {
                for (int j = 0; j < n; j++) {
                    sum[i] += arr[j][i];
                }
            }

            System.out.print("#"+test+" ");
            for (int i = 0; i < k; i++) {
                System.out.print(sum[i] + " ");
            }
            System.out.println();
        }
    }
}
