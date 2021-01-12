package study.yoo.m2011.d201130.t01;

import java.util.Scanner;
import java.util.Stack;


//https://www.acmicpc.net/problem/2841
public class Main {
    static Stack<Integer>[] a = new Stack[7];
    static int n, m, count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        
        for(int i=1; i<=6; i++)
            a[i] = new Stack<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt(), y = sc.nextInt();
             
            if (a[x].size() == 0) {
                ++count;
                a[x].push(y);
                continue;
            }
            while (a[x].peek() > y) {
                ++count;
                a[x].pop();
                if (a[x].size() == 0) break;
            }
            if (a[x].size()!=0 && a[x].peek() == y) continue;
            ++count;
            a[x].push(y);
        }
        System.out.println(count);
        sc.close();
    }
}


