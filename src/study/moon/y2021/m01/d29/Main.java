package study.moon.y2021.m01.d29;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//https://www.acmicpc.net/problem/2740    [B1]    행렬의 곱셈
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        int row1 = Integer.parseInt(s[0]);
        int col1 = Integer.parseInt(s[1]);

        int[][] arr1 = new int[row1][col1];

        for (int i = 0; i < row1; i++) {
            s = br.readLine().split(" ");
            for (int j = 0; j < col1; j++) {
                arr1[i][j] = Integer.parseInt(s[j]);
            }
        }

        s = br.readLine().split(" ");
        int row2 = Integer.parseInt(s[0]);
        int col2 = Integer.parseInt(s[1]);

        int[][] arr2 = new int[row2][col2];

        for (int i = 0; i < row2; i++) {
            s = br.readLine().split(" ");
            for (int j = 0; j < col2; j++) {
                arr2[i][j] = Integer.parseInt(s[j]);
            }
        }

        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                int sum = 0;
                for (int k = 0; k < col1; k++) {
                    sum += arr1[i][k] * arr2[k][j];
                }

                bw.write(sum + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}


