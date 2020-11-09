package study.moon.woowabros.t05;

/*
    penter = 1100
    pexit  = 0010
    pescape= 1001

    위의 문자들이 4글자이므로 data의 글자들도 4글자로 분할하여 암호화를 시작한다.
    암호의 시작에는 penter가 입력되고 암호의 끝에는 pexit가 입력된다.
    중간에 data를 분할하여 암호화 할 때 penter, pexit, pexcape와 일치하는 패킷이 있으면 pescape을 패킷의 앞에 입력하여 암호화를 진행한다.
    이런 결과를 통해서 얻어지는 암호화 패킷을 구하여라
 */
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
