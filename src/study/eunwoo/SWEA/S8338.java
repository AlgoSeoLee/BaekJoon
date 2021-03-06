package study.eunwoo.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [8338. 계산기] https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AWxpQia60FgDFAWL&categoryId=AWxpQia60FgDFAWL&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=JAVA&select-1=3&pageSize=10&pageIndex=4
public class S8338 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int test=1; test<=t; test++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            int [] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int sum = arr[0];

            for (int i = 1; i < arr.length; i++) {
                if (sum * arr[i] > sum + arr[i]) {
                    sum *= arr[i];
                } else {
                    sum += arr[i];
                }
            }

            System.out.println("#"+test+" "+sum);
        }
    }
}
