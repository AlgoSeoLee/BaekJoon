package study.moon.oncoder.t03;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution("aaaaabbc",1);
    }

    public int solution(String s, int n){
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        return 0;
    }
}
