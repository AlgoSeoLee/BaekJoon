package study.moon.y2020.m12.d201203.t03;

import java.io.*;
//https://www.acmicpc.net/problem/2920
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] split = br.readLine().split(" ");
        if (isAscending(split)) {
            bw.write("ascending");
        } else if(isDescending(split)) {
            bw.write("descending");
        } else {
            bw.write("mixed");
        }
        bw.flush();
        bw.close();
    }

    private static boolean isAscending(String[] strings) {
        for (int i = 1; i <= 8; i++) {
            if(!strings[i-1].equals(String.valueOf(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean isDescending(String[] strings) {
        for (int i = 1; i <= 8; i++) {
            if(!strings[i-1].equals(String.valueOf(9-i))) {
                return false;
            }
        }
        return true;
    }
}
