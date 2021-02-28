package study.eunwoo.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [7193. 승현이의 수학공부] https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AWksRkI6AR0DFAVE&categoryId=AWksRkI6AR0DFAVE&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=3&pageSize=10&pageIndex=5
public class S7193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int test=1; test<=t; test++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            String s = st.nextToken();

            int sum = 0;

            for (int i = 0; i < s.length(); i++) {
                sum += Character.getNumericValue(s.charAt(i));
            }

            System.out.println("#"+test+" "+sum % (n - 1));
        }
    }
}
