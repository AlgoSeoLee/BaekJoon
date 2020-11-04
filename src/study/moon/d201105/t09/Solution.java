package study.moon.d201105.t09;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("browoanoommnaon"));
    }

    public String solution(String cryptogram) {
        StringBuilder builder = new StringBuilder(cryptogram);
        boolean isEnd = false;
        while(!isEnd) {
            isEnd = true;
            for (int i = 1; i < builder.length(); i++) {
                if (builder.charAt(i - 1) == builder.charAt(i)) {
                    builder.deleteCharAt(i);
                    builder.deleteCharAt(i-1);
                    isEnd = false;
                    i-=2;
                }
            }
        }
        return builder.toString();
    }
}
