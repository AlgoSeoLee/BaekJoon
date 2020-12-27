package study.moon.y2020.m11.d201123.t01;

import java.io.*;

// https://www.acmicpc.net/problem/2447
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        char[][] arr = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = '*';
            }
        }

        drawStar(arr,0,0,n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bw.write(arr[i][j]);
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    private static void drawStar(char[][] arr, int startX, int startY, int size) {
        int divider = size / 3;

        if(divider != 1){
            drawStar(arr, startX, startY, divider);
            drawStar(arr, startX + divider, startY, divider);
            drawStar(arr, startX + 2 * divider, startY, divider);
            drawStar(arr, startX, startY + divider, divider);
            drawStar(arr, startX + 2 * divider, startY + divider, divider);
            drawStar(arr, startX, startY + 2 * divider, divider);
            drawStar(arr, startX + divider, startY + 2 * divider, divider);
            drawStar(arr, startX + 2 * divider, startY + 2 * divider, divider);
        }

        for (int i = startX; i < startX + size; i++) {
            for (int j = startY; j < startY + size; j++) {
                if((i - startX) / divider == 1 && (j - startY) / divider == 1) {
                    arr[i][j] = ' ';
                }
            }
        }
    }
}
