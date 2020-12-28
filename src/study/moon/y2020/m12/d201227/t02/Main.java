package study.moon.y2020.m12.d201227.t02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        arr = new char[n][2*n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2*n; j++) {
                arr[i][j] = ' ';
            }
        }
        setStar(0,0,n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2*n; j++) {
                bw.write(arr[i][j]);
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    private static void setStar(int startX, int startY, int size) {
        if (size==3) {
            arr[startY][startX+2] = '*';
            arr[startY+1][startX+1] = '*';
            arr[startY+1][startX+3] = '*';
            arr[startY+2][startX] = '*';
            arr[startY+2][startX+1] = '*';
            arr[startY+2][startX+2] = '*';
            arr[startY+2][startX+3] = '*';
            arr[startY+2][startX+4] = '*';
            return;
        }
        setStar(startX+size/2,startY,size/2);
        setStar(startX,startY+size/2,size/2);
        setStar(startX+size,startY+size/2,size/2);
    }

}
