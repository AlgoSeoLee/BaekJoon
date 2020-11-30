package study.moon.oncoder.t02;

public class Solution{
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    public int solution(int page, int[] broken) {
        String s = Integer.toString(page);
        StringBuilder builder1 = new StringBuilder();
        StringBuilder builder2 = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(!isContain(broken,s.charAt(i))) {
                builder1.append(s.charAt(i));
                builder2.append(s.charAt(i));
            }else {
                break;
            }
        }
        return 0;
    }

    public boolean isContain(int[] broken, char c) {
        int numericValue = Character.getNumericValue(c);
        for (int i = 0; i < broken.length; i++) {
            if(broken[i] == numericValue) {
                return true;
            }
        }
        return false;
    }
}
