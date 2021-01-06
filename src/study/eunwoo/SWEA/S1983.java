package study.eunwoo.SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class S1983 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String [] alpha = { "D0", "C-", "C0", "C+", "B-", "B0", "B+", "A-", "A0", "A+" };

        int T = sc.nextInt();
        for (int test=0; test<T; test++) {
            int N = sc.nextInt(); // 학생 수
            int K = sc.nextInt() - 1; // 조회할 학생의 번호

            int [] score = new int[N];
            for (int i=0; i<N; i++) {
                int midExam = sc.nextInt();
                int finalExam = sc.nextInt();
                int homework = sc.nextInt();

                score[i] = midExam * 35 + finalExam * 45 + homework * 20;
            }

            int student = score[K]; // K번째 학생의 성적
            Arrays.sort(score);

            int index = -1;
            for (int i=0; i<N; i++) {
                if (score[i] == student) {
                    index = i;
                    break;
                }
            }

            int answer = index/(N/10);
            System.out.format("#%d %s\n", (test+1), alpha[answer]);
        }
    }
}
