package study.yoo.d201109.t01;

import java.util.Scanner;

//https://www.acmicpc.net/problem/1003
public class Main {

	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
 
        int[][] f = new int[41][2];
 
        f[0][0] = 1;
        f[1][1] = 1;
        for (int i = 2; i < 41; i++) {
            for (int j = 0; j < 2; j++) {
                f[i][j] = f[i - 1][j] + f[i - 2][j];
            }
        }
 
        for (int i = 0; i < n; i++) {
            int d = sc.nextInt();
 
            System.out.println(f[d][0] + " " + f[d][1]);
 
        }
	}

}
