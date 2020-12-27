package study.moon.y2020.m11.d201105.t07;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(13));
        System.out.println(solution.solution(33));
    }

    public int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            String s = Integer.toString(i);
            for (int j = 0; j < s.length(); j++) {
                if(s.charAt(j)=='3'||s.charAt(j)=='6'||s.charAt(j)=='9') {
                    answer++;
                }
            }
        }
        return answer;
    }
}
