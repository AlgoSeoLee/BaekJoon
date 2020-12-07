package study.moon.d201207.t03;

import java.io.IOException;
import java.util.Scanner;

//https://www.acmicpc.net/problem/1436
public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int i = 0;
        int count = 0;
        int[] answer = new int[n];
        while(answer[n-1]==0) {
            String number = Integer.toString(i);
            if(number.contains("666")) {
                answer[count] = i;
                count++;
            }
            i++;
        }

        System.out.println(answer[n-1]);
    }
}
