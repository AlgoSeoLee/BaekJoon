package study.yoo.m2102.d210204.t02;

import java.util.ArrayList;

// 줄 서는 방법 3
class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        ArrayList<Integer> list = new ArrayList<>();
        long factorial = 1;
        
        for (int i = 1; i <= n; i++) {
            list.add(i);
            factorial *= i;
        }

        int i = 0;
        long remain = k - 1;

        while (i < n) {
            factorial = factorial / (n - i);
            long value = remain / factorial;
            answer[i++] = list.get((int)value);
            list.remove((int)value);
            remain = remain % factorial;
        }
        return answer;
    }
}