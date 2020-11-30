package study.moon.oncoder.t04;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    public String solution(String cardNumber){
        StringBuilder builder = new StringBuilder();
        if (cardNumber.length()%2==0) {//짝수
            for (int i = 0; i < cardNumber.length(); i++) {
                if(i % 2 == 0) {
                    builder.append(Character.getNumericValue(cardNumber.charAt(i)) * 2);
                }else {
                    builder.append(cardNumber.charAt(i));
                }
            }
        }else {//홀수
            for (int i = 0; i < cardNumber.length(); i++) {
                if(i % 2 != 0) {
                    builder.append(Character.getNumericValue(cardNumber.charAt(i)) * 2);
                }else {
                    builder.append(cardNumber.charAt(i));
                }
            }
        }
        int answer = 0;
        for (int i = 0; i < builder.length(); i++) {
            answer+=Integer.parseInt(String.valueOf(builder.charAt(i)));
        }
        if(answer % 10 == 0) {
            return "VALID";
        }else {
            return "INVALID";
        }
    }
}
