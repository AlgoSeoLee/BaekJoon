package study.moon.y2020.m11.d201105.t06;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{97, 98}, new int[]{197, 198}));
        System.out.println(solution.solution(new int[]{131, 132}, new int[]{211, 212}));
        System.out.println(solution.solution(new int[]{99, 102}, new int[]{211, 212}));
    }

    public int solution(int[] pobi, int[] crong) {
        if (pobi[1] - pobi[0]!=1) {
            return -1;
        }
        if (crong[1] - crong[0]!=1) {
            return -1;
        }

        int pobiPoint = Math.max(getNumberMax(pobi[0]),getNumberMax(pobi[1]));
        int crongPoint = Math.max(getNumberMax(crong[0]),getNumberMax(crong[1]));

        if(pobiPoint < crongPoint) {
            return 2;
        }else if(pobiPoint == crongPoint) {
            return 0;
        } else {
            return 1;
        }
    }

    public int getNumberMax(int number) {
        String string = Integer.toString(number);
        int MAX_PLUS = 0;
        int MAX_MULTI = 1;
        //더하기
        for (int i = 0; i < string.length(); i++) {
            MAX_PLUS += Character.getNumericValue(string.charAt(i));
        }
        //곱하기
        for (int i = 0; i < string.length(); i++) {
            MAX_MULTI *= Character.getNumericValue(string.charAt(i));
        }
        return Math.max(MAX_MULTI,MAX_PLUS);
    }
}
