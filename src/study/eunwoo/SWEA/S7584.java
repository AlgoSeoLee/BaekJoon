package study.eunwoo.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// [7584. 자가 복제 문자열] https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AWpMsQfaCPMDFAQi&categoryId=AWpMsQfaCPMDFAQi&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=3&pageSize=10&pageIndex=5&&&&&&&&&&
public class S7584 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int test=1; test<=t; test++) {
            long k = Long.parseLong(br.readLine()) - 1;

            int answer = 0;

            while (k > 0) {
                if (k % 2 == 1) k = (k - 1) / 2;
                if (k % 4 == 0) {
                    break;
                } else if (k % 2 == 0) {
                    answer = 1;
                    break;
                }
            }
            System.out.println("#"+test+" "+answer);

        }
    }
}
