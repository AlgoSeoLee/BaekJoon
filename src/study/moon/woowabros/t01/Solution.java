package study.moon.woowabros.t01;

/*
점수표
A+  10
A0  9
B+  8
B0  7
C+  6
C0  5
D+  4
D0  3
F   0

입력
grades = [A+, D+, F, C0], weights = [2, 5, 10, 3], threshold = 50

문제
점수표의 점수와 가중치를 곱해 기준점수보다 높으면 합격, 낮은면 불합격을 주려고 한다. 해당 인원이 합격인지 불합격인지 판별하기 위한 점수를 구하시오.
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new String[]{"A+", "D+", "F", "C0"}, new int[]{2, 5, 10, 3}, 50));
        System.out.println(solution.solution(new String[]{"B+", "A0", "C+"}, new int[]{6,7,8}, 200));
    }

    public int solution(String[] grades, int[] weights, int threshold) {
        int count = 0;
        int[] answer = new int[grades.length];
        for (int i = 0; i < grades.length; i++) {
            if(grades[i].equals("A+")) {
                answer[i] = 10;
            } else if(grades[i].equals("A0")) {
                answer[i] = 9;
            } else if(grades[i].equals("B+")) {
                answer[i] = 8;
            } else if(grades[i].equals("B0")) {
                answer[i] = 7;
            } else if(grades[i].equals("C+")) {
                answer[i] = 6;
            } else if(grades[i].equals("C0")) {
                answer[i] = 5;
            } else if(grades[i].equals("D+")) {
                answer[i] = 4;
            } else if(grades[i].equals("D0")) {
                answer[i] = 3;
            } else if(grades[i].equals("F")) {
                answer[i] = 0;
            }
        }

        for (int i = 0; i < grades.length; i++) {
            count += answer[i] * weights[i];
        }
        return count - threshold;
    }
}
