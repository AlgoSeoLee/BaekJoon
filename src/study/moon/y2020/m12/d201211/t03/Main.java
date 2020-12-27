package study.moon.y2020.m12.d201211.t03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//https://www.acmicpc.net/problem/2630
public class Main {

    static int a = 0;
    static int b = 0;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }
        int papers = getPapers(0, 0, n);
        if (papers != -1) {
            if (papers == 0) {
                a++;
            } else {
                b++;
            }
        }
        bw.write(a + "\n");
        bw.write(b + "\n");
        bw.flush();
        bw.close();
    }

    private static int getPapers(int startX, int startY, int size) {
        size /= 2;
        if (size == 0) {
            return arr[startX][startY];
        }
        int[] papers = new int[4];
        int count = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                papers[count] = getPapers(startX + i * size, startY + j * size, size);
                count++;
            }
        }
        if (isAllSame(papers) != -1) {
            return isAllSame(papers);
        } else {
            addPapers(papers);
            return -1;
        }
    }

    private static int isAllSame(int[] papers) {
        int value = papers[0];
        for (int i = 1; i < 4; i++) {
            if (value != papers[i]) {
                return -1;
            }
        }
        return value;
    }

    private static void addPapers(int[] papers) {
        for (int i = 0; i < 4; i++) {
            if (papers[i] == 0) {
                a++;
            }
            if (papers[i] == 1) {
                b++;
            }
        }
    }

}
