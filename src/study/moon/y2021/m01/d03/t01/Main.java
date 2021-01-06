package study.moon.y2021.m01.d03.t01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//https://www.acmicpc.net/problem/15652    [S3]    N과M(5)
public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int r = Integer.parseInt(s[1]);

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        int[] output = new int[n];

        permutation(arr, output, 0, n, r);
        bw.flush();
        bw.close();
    }


    //순열
    //사용 예시: permutation(arr, output, visited, 0, n, 3, answer);
    static void permutation(int[] arr, int[] output, int depth, int n, int r) throws IOException {
        if (depth == r) {
            permPrint(output, r);
            return;
        }

        for (int i = 0; i < n; i++) {
            output[depth] = arr[i];
            permutation(arr, output, depth + 1, n, r);
        }
    }

    //순열 출력
    static void permPrint(int[] output, int r) throws IOException {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < r; i++) {
            if (i == 0) {
                builder.append(output[i]).append(" ");
            }else {
                if (output[i]< output[i-1]) {
                    return;
                } else {
                    builder.append(output[i]).append(" ");
                }
            }
        }
        bw.write(builder.toString()+"\n");
    }
}
