package study.eunwoo.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// [7510. 상원이의 연속 합] https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AWoEzJFa2A4DFARq&categoryId=AWoEzJFa2A4DFARq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=3&pageSize=10&pageIndex=5
public class S7510 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int test=1; test<=t; test++) {
            int n = Integer.parseInt(br.readLine());

            int count = 1;
            int sum;

            for (int i = 1; i <= n-1; i++) {
                sum = 0;
                sum += i;
                for (int j = i+1; j <= n; j++) {
                    sum += j;

                    if (sum > n) break;
                    if (sum == n) {
                        count++;
                        break;
                    }
                }
            }

            System.out.println("#"+test+" "+count);
        }
    }
}
