package study.moon.y2020.m12.d201203.t08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//https://www.acmicpc.net/problem/1978
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        final int MAX = 1000;
        boolean[] prime = new boolean[MAX+1];
        Arrays.fill(prime,true);
        prime[0]=false;
        prime[1]=false;
        for (int i = 2 ; i<= Math.sqrt(MAX) ; i++) {
            for (int j = 2 * i ; j <= MAX; j+=i) {
                prime[j] = false;
            }
        }
        String[] split = br.readLine().split(" ");
        int answer = 0;
        for (String s : split) {
            if (prime[Integer.parseInt(s)]) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
