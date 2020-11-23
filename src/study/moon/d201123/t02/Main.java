package study.moon.d201123.t02;

import java.io.*;
// https://www.acmicpc.net/problem/1992
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[][] arr = new String[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = String.valueOf(s.charAt(j));
            }
        }

        bw.write(getQuadTree(arr,0,0,n));
        bw.flush();
        bw.close();
    }

    private static String getQuadTree(String[][] arr, int startX, int startY, int size) {
        int divider = size/2;
        if (size == 2) {
            if (arr[startX][startY].equals("0")
                    && arr[startX][startY + 1].equals("0")
                    && arr[startX + 1][startY].equals("0")
                    && arr[startX + 1][startY + 1].equals("0")
            ) {
                return "0";
            } else if (arr[startX][startY].equals("1")
                    && arr[startX][startY + 1].equals("1")
                    && arr[startX + 1][startY].equals("1")
                    && arr[startX + 1][startY + 1].equals("1")
            ) {
                return "1";
            } else {
                return "("+arr[startX][startY]+arr[startX][startY + 1]+arr[startX + 1][startY]+arr[startX + 1][startY + 1]+")";
            }
        }

        String quadTree1= getQuadTree(arr, startX, startY, divider);
        String quadTree2 = getQuadTree(arr, startX, startY + divider, divider);
        String quadTree3 = getQuadTree(arr, startX + divider, startY, divider);
        String quadTree4 = getQuadTree(arr, startX + divider, startY + divider, divider);

        if(quadTree1.equals("0") && quadTree2.equals("0") && quadTree3.equals("0") && quadTree4.equals("0")) {
            return "0";
        } else if(quadTree1.equals("1") && quadTree2.equals("1") && quadTree3.equals("1") && quadTree4.equals("1")) {
            return "1";
        } else {
            return "("+quadTree1+quadTree2+quadTree3+quadTree4+")";
        }
    }
}
