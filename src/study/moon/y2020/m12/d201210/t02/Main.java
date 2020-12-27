package study.moon.y2020.m12.d201210.t02;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BigInteger[] factorial = new BigInteger[n+1];
        factorial[0] = BigInteger.ONE;
        for (int i = 1; i < factorial.length; i++) {
            factorial[i] = factorial[i-1].multiply(BigInteger.valueOf(i));
        }
        String number = factorial[n].toString();
        int count = 0;
        for (int i = number.length()-1; i >=0 ; i--) {
            if(number.charAt(i)!='0') {
                break;
            }
            count++;
        }
        System.out.println(count);
    }
}
