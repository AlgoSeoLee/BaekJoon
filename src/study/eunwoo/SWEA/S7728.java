package study.eunwoo.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// [7728. 다양성 측정] https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AWq40NEKLyADFARG&categoryId=AWq40NEKLyADFARG&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=3&pageSize=10&pageIndex=5
public class S7728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int test=1; test<=t; test++) {
            String str = br.readLine();

            boolean [] check = new boolean[10];

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                int num = Character.getNumericValue(c);

                if (!check[num]) {
                    check[num] = true;
                }
            }

            int count = 0;

            for (int i = 0; i < 10; i++) {
                if (check[i]) count++;
            }

            System.out.println("#"+test+" "+count);
        }
    }
}
