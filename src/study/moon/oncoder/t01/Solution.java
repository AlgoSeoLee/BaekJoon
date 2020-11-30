package study.moon.oncoder.t01;

import java.util.Arrays;

public class Solution{
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{50,62,93}));
    }

    public int solution(int[] goods){
        int answer = 0;
        Arrays.sort(goods);
        if(goods[0]<50) {
            goods[1] = goods[1] + goods[0];
            goods[0] = 0;
        }
        if(goods[1] < 50) {
            goods[2] = goods[2] + goods[1];
            goods[1] = 0;
        }

        int count = 0;
        for (int i = 0; i < 3; i++) {
            if(goods[i] >= 50) {
                count++;
                goods[i] -= 50;
            }
        }
        for (int i = 0; i < goods.length; i++) {
            answer += goods[i];
        }
        answer += (40 * count);
        return answer;
    }
}
