package study.moon.y2021.m02.d24;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//https://www.acmicpc.net/problem/1300    [G3]    K번째 수
public class Main {

    static long N;
    static long K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        long start = 1L;
        long end = K;
        long answer = 0L;
        while(start<=end) {
            long mid = start+end>>>1;
            long index = getLastIndexOf(mid);
            if (index>=K) {
                end = mid - 1;
                answer = mid;
            } else {
                start = mid + 1;
            }
        }
        bw.write(answer+"");
        bw.flush();
        bw.close();
        br.close();
    }

    private static long getLastIndexOf(long number) {
        long count = 0;
        for (int i = 1; i <= N; i++) {
            count += Math.min(number / i, N);
        }
        return count;
    }
}
