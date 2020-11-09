package study.moon.woowabros.t02;

/*

 */
public class Solution {
    public long[] solution(String s, String op) {
        long[] answer = new long[s.length()-1];
        for (int i = 1; i < s.length(); i++) {
            answer[i-1] = calculate(getNumber(s.substring(0,i)),op,getNumber(s.substring(i)));
        }
        return answer;
    }

    public long calculate(long a, String op, long b) {
        if(op.equals("+")) {
            return a + b;
        } else if(op.equals("-")) {
            return a - b;
        } else if(op.equals("*")) {
            return a * b;
        } else {
            return 0;
        }
    }

    public long getNumber(String number) {
        if(number.equals("0")) {
            return 0L;
        }
        StringBuilder builder = new StringBuilder(number);
        while (builder.charAt(0)=='0') {
            builder.deleteCharAt(0);
        }
        return Long.parseLong(builder.toString());
    }
}
