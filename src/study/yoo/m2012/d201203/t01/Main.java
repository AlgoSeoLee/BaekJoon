package study.yoo.m2012.d201203.t01;

import java.util.Scanner;


//https://www.acmicpc.net/problem/14720
public class Main {
    public static void main(String args[]) {
        int count = 0;
        int[] rule = {0, 1, 2};
        int rule_index = 0;
        
        Scanner sc = new Scanner(System.in);
        int all_milk = sc.nextInt();
        
        for(int i = 0; i < all_milk; i++) {
        	//0, 1, 2일때만 count증가
            if(sc.nextInt() == rule[rule_index % 3]) {
                count++;
                rule_index++;
            }
        }
        System.out.println(count);
    }
}
 

