package study.moon.y2020.m11.d201105.t04;

import java.util.Arrays;
//https://m.blog.naver.com/PostView.nhn?blogId=spring1a&logNo=221490064807&proxyReferer=https:%2F%2Fwww.google.com%2F
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(50237)));
        System.out.println(Arrays.toString(solution.solution(15000)));
    }

    public int[] solution(int money) {
        int[] answer = new int[9];
        while(money != 0) {
            if (money>=50000) {
                answer[0]++;
                money -= 50000;
                continue;
            }
            if (money>=10000) {
                answer[1]++;
                money -= 10000;
                continue;
            }
            if (money>=5000) {
                answer[2]++;
                money -= 5000;
                continue;
            }
            if (money>=1000) {
                answer[3]++;
                money -= 1000;
                continue;
            }
            if (money>=500) {
                answer[4]++;
                money -= 500;
                continue;
            }
            if (money>=100) {
                answer[5]++;
                money -= 100;
                continue;
            }
            if (money>=50) {
                answer[6]++;
                money -= 50;
                continue;
            }
            if (money>=10) {
                answer[7]++;
                money -= 10;
                continue;
            }if (money>=1) {
                answer[8]++;
                money -= 1;
            }
        }
        return answer;
    }
}
