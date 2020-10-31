package study.moon.d201029.t03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.acmicpc.net/problem/1300
public class Main {
    static long N, K, res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Long.parseLong(br.readLine());
        K = Long.parseLong(br.readLine());

        long left = 1;
        long right = K;

        System.out.println(BST(left, right));
    }

    static long BST(long left, long right) {
        int cnt = 0;
        long mid = (left + right) / 2;
        if (left > right) return res;
        for (int i = 1; i <= N; i++) {
            cnt += Math.min(mid / i, N);
        }

        if (K <= cnt) {
            res = mid;
            return BST(left, mid - 1);
        } else {
            return BST(mid + 1, right);
        }
    }
}
