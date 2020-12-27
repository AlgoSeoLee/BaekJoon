package study.moon.y2020.m12.d201208.t07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
////https://www.acmicpc.net/problem/15829
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String number = br.readLine();
        bw.write(hash(number));
        bw.flush();
        bw.close();
    }

    public static String hash(String string) {
        BigInteger[] arr = new BigInteger[string.length()];
        for (int i = 0; i < string.length(); i++) {
            arr[i] = BigInteger.valueOf(string.charAt(i) - 96);
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                arr[i] = arr[i].multiply(BigInteger.valueOf(31));
            }
        }
        BigInteger number = BigInteger.ZERO;
        for (BigInteger bigInteger : arr) {
            number = number.add(bigInteger);
        }
        return number.mod(BigInteger.valueOf(1234567891)).toString();
    }

}
