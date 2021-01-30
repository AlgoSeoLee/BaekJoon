package study.eunwoo.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [8500. 극장 좌석] https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AWz5yIfq74QDFARQ&categoryId=AWz5yIfq74QDFARQ&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=JAVA&select-1=3&pageSize=10&pageIndex=4
public class S8500 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int test=1; test<=t; test++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            int sum = 0;
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < n; i++) {
                int tmp = Integer.parseInt(st.nextToken());

                if (tmp > max) {
                    max = tmp;
                }

                sum += tmp;
            }

            System.out.println("#"+test+" "+(n + sum + max));
        }
    }
}
