package study.moon.y2020.m12.d201207.t15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//https://www.acmicpc.net/problem/1654
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int k;
    static int n;

    public static void main(String[] args) throws IOException {
        String[] split = br.readLine().split(" ");
        k = Integer.parseInt(split[0]);
        n = Integer.parseInt(split[1]);
        int[] lines = new int[k];
        for (int i = 0; i < k; i++) {
            lines[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(lines);

        int min = 1;
        int max = lines[k-1];

        while (min <= max) {
            int mid = (min + max) >>> 1;
            int count = getCount(lines, mid);
            if (count < n) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        System.out.println(max);
    }

    private static int getCount(int[] lines, long answer) {
        int count = 0;
        for (int line : lines) {
            count += line / answer;
        }
        return count;
    }
}
