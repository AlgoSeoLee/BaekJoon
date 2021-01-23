package study.eunwoo.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// [8840 아바바바] https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AW4Z8x2KAL8DFAQ7
public class S8840 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int test=1; test<=t; test++) {
            int n = Integer.parseInt(br.readLine());

            long answer = (n - 1) / 2;

            System.out.println("#"+test+" "+answer*answer);
        }
    }
}
