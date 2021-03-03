package study.moon.y2021.m03.d03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*

소마코테 발판밟기
10
3 5 -1 -2 4 4 3 -2 -3 -2

*/
public class Main {

    static boolean[] visit;
    static int[] arr;
    static int answer = Integer.MIN_VALUE;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        String[] split = br.readLine().split(" ");
        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(split[i - 1]);
        }

        for (int i = 1; i <= 3; i++) {
            startAt(i);
        }

        bw.write(answer+1 + "");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void startAt(int index) {
        visit = new boolean[N + 1];
        int count = 0;
        while (true) {
            if (visit[index]) {
                if (count > answer) {
                    answer = count;
                }
                break;
            }
            visit[index] = true;
            index += arr[index];
            count++;
        }
    }
}
