package study.eunwoo.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [7272. 안경이 없어!] https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWl0ZQ8qn7UDFAXz
public class S7272 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int [] alpha = { 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0 };

        int t = Integer.parseInt(br.readLine());

        for (int test=1; test<=t; test++) {
            st = new StringTokenizer(br.readLine());

            String str1 = st.nextToken();
            String str2 = st.nextToken();

            System.out.print("#"+test+" ");
            if (str1.length() != str2.length()) {
                System.out.println("DIFF");
                continue;
            }

            boolean flag = true;

            for (int i = 0; i < str1.length(); i++) {
                if (str1.charAt(i) == 'B' || str2.charAt(i) == 'B') {
                    if (str1.charAt(i) != str2.charAt(i)) {
                        flag = false;
                        break;
                    }

                } else {
                    if (alpha[str1.charAt(i) - 'A'] != alpha[str2.charAt(i) - 'A']) {
                        flag = false;
                        break;
                    }
                }
            }

            if (flag) {
                System.out.println("SAME");
            } else {
                System.out.println("DIFF");
            }
        }
    }
}
