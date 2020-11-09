package study.yoo.d201109.t03;

import java.util.Scanner;

//https://www.acmicpc.net/problem/1110

public class Main {

	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
         
        int number = n;
        int count = 0;
         
        do {
            number = number % 10 * 10 + (number / 10 + number % 10) % 10;
            count++;
        } while (n != number);
         
        System.out.println(count);
	}

}
