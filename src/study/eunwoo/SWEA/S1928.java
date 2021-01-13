package study.eunwoo.SWEA;

import java.util.Base64;
import java.util.Scanner;

// [1928 Base64 Decoder] https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PR4DKAG0DFAUq&categoryId=AV5PR4DKAG0DFAUq&categoryType=CODE
public class S1928 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int test=1; test<=T; test++) {
            String encoded = sc.next();
            String decoded = new String(Base64.getDecoder().decode(encoded));

            System.out.println("#"+test+" "+decoded);
        }
    }
}
