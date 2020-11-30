package study.moon.d201130.t01;

import java.io.*;

//https://www.acmicpc.net/problem/2749
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        int pisano = 1_500_000;
        long[] arr = new long[pisano];
        arr[0] = 0; arr[1] = 1;

        for(int i = 2 ; i<pisano && i<=n ; i++){
            arr[i] = (arr[i-1] + arr[i-2]) % 1_000_000;
        }

        if(n >=pisano){
            n %= pisano;
        }

        System.out.println(arr[(int) n]);
    }
}
