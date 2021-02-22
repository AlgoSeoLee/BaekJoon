package study.moon.y2021.m02.d21;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//https://www.acmicpc.net/problem/1138    [S2]    한줄로서기
public class Main {

    static int[] arr;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        answer = new int[N];
        String[] s = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(s[i - 1]);
        }
        for (int i = 1; i <= N; i++) {
            int count = 0;
            for (int j = 0; j < arr[i]; j++) {
                count++;
            }
            for (int j = 0; j < count; j++) {
                if (answer[j] < i && answer[j] != 0) {
                    count++;
                }
            }
            while(answer[count]!=0) {
                count++;
            }
            answer[count] = i;
        }
        for (int j : answer) {
            bw.write(j + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
