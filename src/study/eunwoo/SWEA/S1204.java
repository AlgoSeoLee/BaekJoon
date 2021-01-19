package study.eunwoo.SWEA;

import java.util.Scanner;

// [1204 최빈수 구하기] https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV13zo1KAAACFAYh&categoryId=AV13zo1KAAACFAYh&categoryType=CODE
public class S1204 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int test=1; test<=T; test++) {
            int N = sc.nextInt(); // 테스트 케이스 번호
            int [] count = new int[101]; // 0~100

            for (int i=0; i<1000; i++) {
                int score = sc.nextInt();
                count[score]++;
            }

            int max = -1;
            int answer = 0;
            for(int i=0; i<100; ++i){
                if(max <= count[i]){
                    max = count[i];
                    answer = i;
                }
            }

            System.out.println("#"+test+" "+answer);
        }
    }
}
