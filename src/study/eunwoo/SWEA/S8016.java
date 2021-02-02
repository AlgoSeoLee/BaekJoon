package study.eunwoo.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// [8016. 홀수 피라미드] https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AWvzGUKKPVwDFASy&categoryId=AWvzGUKKPVwDFASy&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=JAVA&select-1=3&pageSize=10&pageIndex=4&&&&&&&&&&
public class S8016 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int test=1; test<=t; test++) {
            long n = Integer.parseInt(br.readLine());

            long a = 2 * (n*n) - 4 * n + 3;
            long b = 2 * (n*n) - 1;

            System.out.println("#"+test+" "+a+" "+b);
        }
    }
}
