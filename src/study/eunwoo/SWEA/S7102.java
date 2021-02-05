package study.eunwoo.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [7102. 준홍이의 카드놀이] https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AWkIlHWqBYcDFAXC&categoryId=AWkIlHWqBYcDFAXC&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=3&pageSize=10&pageIndex=5
public class S7102 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int test=1; test<=t; test++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int [] count = new int[n+m+1];

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    count[i+j]++;
                }
            }

            int k = Math.min(n, m);

            System.out.print("#"+test+" ");
            for (int i = 0; i < count.length; i++) {
                if (count[i] == k) { // 배열에서 k만큼의 값이 들어있는 인덱스를 뽑아낸다
                    System.out.print(i+" ");
                }
            }
            System.out.println();
        }
    }
}
