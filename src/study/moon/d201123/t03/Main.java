package study.moon.d201123.t03;

import java.io.*;

public class Main {
    static int answer = 0;
    static boolean isEnd;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] split = br.readLine().split(" ");
        int n = (int) Math.pow(2, Double.parseDouble(split[0])+1);
        int r = Integer.parseInt(split[1]);
        int c = Integer.parseInt(split[2]);
        getNumber(0,0,n,r,c);
        bw.write(answer+"");
        bw.flush();
        bw.close();
    }

    private static void getNumber(int startX, int startY, int size, int r, int c) {
        if(isEnd) {
            return;
        }
        int divider = size/2;
        if(size == 2) {
            if(startX == r && startY == c) {
                isEnd=true;
                return;
            } else {
                answer++;
            }
            if(startX == r && startY + 1 == c) {
                isEnd=true;
                return;
            } else {
                answer++;
            }
            if(startX + 1 == r && startY == c) {
                isEnd=true;
                return;
            } else {
                answer++;
            }
            if(startX + 1 == r && startY + 1 == c) {
                isEnd=true;
                return;
            } else {
                answer++;
            }
            return;
        }

        getNumber(startX, startY, divider, r, c);
        getNumber(startX, startY + divider, divider, r, c);
        getNumber(startX + divider, startY, divider, r, c);
        getNumber(startX + divider, startY + divider, divider, r, c);
    }
}
