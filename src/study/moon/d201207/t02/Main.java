package study.moon.d201207.t02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
//https://www.acmicpc.net/problem/2609
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] split = br.readLine().split(" ");
        int a = Integer.parseInt(split[0]);
        int b = Integer.parseInt(split[1]);
        int gcd = getGCD(a, b);
        int lcm = getLCM(a, b, a, b);
        bw.write(gcd+"\n");
        bw.write(lcm+"");
        bw.flush();
        bw.close();

    }

    private static int getGCD(int a, int b) {
        int c = a % b;
        if (c == 0) {
            return b;
        }
        return getGCD(b, c);
    }

    private static int getLCM(int a, int b, final int num1, final int num2) {
        if (a == b) {
            return a;
        }

        if (a > b) {
            return getLCM(a, b + num2, num1, num2);
        }

        return getLCM(a + num1, b, num1, num2);
    }
}
