package study.eunwoo.SWEA;

import java.util.Scanner;

// [1288 새로운 불면증 치료법] https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV18_yw6I9MCFAZN&categoryId=AV18_yw6I9MCFAZN&categoryType=CODE
public class S1288 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int test=1; test<=T; test++) {
            int N = sc.nextInt();
            boolean [] visit = new boolean[10]; // 숫자가 나왔는지 체크하는 배열
            int check = 0; // 배열이 전부 찼는지 체크
            int count = 1; // N에 곱해줄 카운트

            while (true) {
                int mul = N * count; // 배수
                String str = Integer.toString(mul);
                
                for (int i=0; i<str.length(); i++) {
                    char c = str.charAt(i);
                    int tmp = Character.getNumericValue(c);

                    if (!visit[tmp]) {
                        visit[tmp] = true;
                        check++;
                    } else {
                        continue;
                    }
                }
                
                if (check == 10) {
                    break;
                }
                
                count++;
            }

            System.out.println("#"+test+" "+N*count);
        }
    }
}
