package study.moon.y2021.m01.d03.t02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

//https://www.acmicpc.net/problem/15654    [S3]    N 과 M(5)
public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int n =Integer.parseInt(s[0]);
        int r =Integer.parseInt(s[1]);
        s = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(arr);
        int[] output = new int[n];
        boolean[] visited = new boolean[n];


        permutation(arr, output, visited, 0, n, r);
        bw.flush();
        bw.close();

    }

    //순열
    //사용 예시: permutation(arr, output, visited, 0, n, 3, answer);
    static void permutation(int[] arr, int[] output, boolean[] visited, int depth, int n, int r)
        throws IOException {
        if (depth == r) {
            permPrint(output, r);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                permutation(arr, output, visited, depth + 1, n, r);
                visited[i] = false;
            }
        }
    }

    //순열 출력
    static void permPrint(int[] arr, int r)throws IOException {
        for (int i = 0; i < r; i++) {
            bw.write(arr[i]+" ");
        }
        bw.write("\n");
    }
}
