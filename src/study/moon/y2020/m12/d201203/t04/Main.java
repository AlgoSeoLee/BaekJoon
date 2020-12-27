package study.moon.y2020.m12.d201203.t04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.acmicpc.net/problem/1018
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        int m = Integer.parseInt(split[0]);
        int n = Integer.parseInt(split[1]);

        int count = 0;
        int min = Integer.MAX_VALUE;

        char[][] arr = new char[m][n];
        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] =s.charAt(j);
            }
        }
        for (int x = 0; x < m-7; x++) {
            for (int y = 0; y < n-7; y++) {
                count = 0;
                for (int i = x; i < x+8; i++) {
                    for (int j = y; j < y+8; j++) {
                        if((i + j) % 2 == 0) {
                            if(arr[i][j] != 'W') {
                                count++;
                            }
                        }else {
                            if(arr[i][j] != 'B') {
                                count++;
                            }
                        }
                    }
                }
                if(count < min) {
                    min = count;
                }
            }
        }

        for (int x = 0; x < m-7; x++) {
            for (int y = 0; y < n-7; y++) {
                count = 0;
                for (int i = x; i < x+8; i++) {
                    for (int j = y; j < y+8; j++) {
                        if((i + j) % 2 == 0) {
                            if(arr[i][j] != 'B') {
                                count++;
                            }
                        }else {
                            if(arr[i][j] != 'W') {
                                count++;
                            }
                        }
                    }
                }
                if(count < min) {
                    min = count;
                }
            }
        }

        System.out.println(min);
    }
}
