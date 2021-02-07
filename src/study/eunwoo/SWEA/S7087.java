package study.eunwoo.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// [7087. 문제 제목 붙이기] https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AWkIdD46A5EDFAXC&categoryId=AWkIdD46A5EDFAXC&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=3&pageSize=10&pageIndex=5
public class S7087 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int test=1; test<=t; test++) {
            int n = Integer.parseInt(br.readLine());

            boolean [] alpha = new boolean[26];
            String [] words = new String[n];

            for (int i = 0; i < n; i++) {
                words[i] = br.readLine();
            }

            Arrays.sort(words);

            int count = 0;

            for (String word : words) {
                char c = word.charAt(0);

                if (!alpha[c - 'A']) {
                    if (c - 'A' == count) {
                        alpha[c - 'A'] = true;
                        count++;
                    } else {
                        break;
                    }
                }
            }

            System.out.println("#"+test+" "+count);
        }
    }
}
