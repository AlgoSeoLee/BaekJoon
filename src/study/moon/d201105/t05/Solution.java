package study.moon.d201105.t05;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("I love you"));
    }

    public String solution(String word) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            builder.append(changeChar(word.charAt(i)));
        }
        return builder.toString();
    }

    public char changeChar(char c) {
        if(c >= 65 && c <= 90) {
            return (char)(90 + 65 - c);
        }
        if(c >= 97 && c <= 122) {
            return (char)(122 + 97 - c);
        }
        return c;
    }
}
