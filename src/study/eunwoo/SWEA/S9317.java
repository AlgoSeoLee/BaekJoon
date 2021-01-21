package study.eunwoo.SWEA;

import java.util.Scanner;

public class S9317 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int test=1; test<=T; test++) {
            int N = sc.nextInt();
            String problem = sc.next();
            String answer = sc.next();

            if (problem.length() > N) {
                problem = problem.substring(0, N+1);
            }

            if (answer.length() > N) {
                answer = answer.substring(0, N+1);
            }

            int count = 0;

            for (int i=0; i<N; i++) {
                if (problem.charAt(i) == answer.charAt(i)) count++;
            }

            System.out.println("#"+test+" "+count);
        }
    }
}
