package study.eunwoo.SWEA;

import java.io.*;
import java.util.StringTokenizer;

// [1946 간단한 압축 풀기] https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PmkDKAOMDFAUq&categoryId=AV5PmkDKAOMDFAUq&categoryType=CODE
public class S1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int test=1; test<=T; test++) {
            int N = Integer.parseInt(br.readLine());

            char [] alpha = new char[N];
            int [] count = new int[N];

            for (int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                alpha[i] = st.nextToken().charAt(0);
                count[i] = Integer.parseInt(st.nextToken());
            }

            int cnt = 0;
            System.out.println("#"+test);
            for (int i=0; i<N; i++) {
                for (int j=0; j<count[i]; j++) {
                    System.out.print(alpha[i]);
                    cnt++;

                    if (cnt == 10) {
                        System.out.println();
                        cnt = 0;
                    }
                }
            }
            System.out.println();
        }
    }
}
