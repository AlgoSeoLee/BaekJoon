package study.moon.y2021.m02.d23;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//https://www.acmicpc.net/problem/1072    [S3]    게임
public class Main {

    static long x, y, z;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] split = br.readLine().split(" ");
        x = Integer.parseInt(split[0]);
        y = Integer.parseInt(split[1]);
        z = (y * 100) / x;

        if (z >= 99) {
            bw.write("-1");
        } else {
            bw.write(binarySearch(1, 99 * x - 100 * y) + "");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static long binarySearch(long start, long end) {
        long mid = 0;
        long rate = 0;
        while (start <= end) {
            mid = (start + end) >>> 1;
            rate = (y + mid) * 100 / (x + mid);
            if (rate <= z) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }
}
