package study.moon.woowabros.t05;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("1100", "0010", "1001", "1101100100101111001111000000"));
    }

    public String solution(String penter, String pexit, String pescape, String data) {
        StringBuilder builder = new StringBuilder();
        int n = penter.length();
        builder.append(penter);
        for (int i = 0; i < data.length(); i += n) {
            String substring = data.substring(i, i + n);
            System.out.println(substring);
            if (substring.equals(penter) || substring.equals(pexit) || substring.equals(pescape)) {
                builder.append(pescape);
            }
            builder.append(substring);
        }
        builder.append(pexit);
        return builder.toString();
    }
}
