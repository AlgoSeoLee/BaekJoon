package study.yoo.m2012.d201224.t02;

import java.util.Scanner;


//https://www.acmicpc.net/problem/4796

public class Main {

    static int l,p,v;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = 1;
        while(true) {
            l = sc.nextInt(); // L일 동안
            p = sc.nextInt(); // 연속 P일
            v = sc.nextInt(); // 휴가 V일
            // 0이 들어오면 종료
            if(l==0) break;

            int result = 0;

            for(int i=0;i<v;) {
                result += l;
                // l일을 증가시켜준다.
                i += l;
                // v일 을 초과하면 뺌
                if(i>=v) result -= i-v;
                // P-L일을 더함
                i+=p-l;
            }
            System.out.println("Case "+tc+": "+result);
            tc++;
        }
    }

}
