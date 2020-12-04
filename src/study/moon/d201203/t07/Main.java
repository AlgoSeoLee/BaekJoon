package study.moon.d201203.t07;

import java.io.*;

//https://www.acmicpc.net/problem/1259
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = "";
        while (!(str=br.readLine()).equals("0")) {
            if(!isPalindrome(str)) {
                bw.write("no\n");
                continue;
            }
            bw.write("yes\n");
        }
        bw.flush();
        bw.close();
    }

    private static boolean isPalindrome(String str) {
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)!=str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
