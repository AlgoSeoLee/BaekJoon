package study.yoo.m2010.d201022.t02;

import study.yoo.m2010.d201022.t02.Solution;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("PpoooyY");
        System.out.println(solution.solution("PpoooyY"));
    }
    boolean solution(String s) {
        boolean answer = true;
        int Pcount = 0;
        int Ycount = 0;
        char[] temp = s.toCharArray();
        
        for (int i =0; i<temp.length; i++){
            if(temp[i] == 'p' || temp[i] == 'P')
                Pcount++;
            else if(temp[i] == 'y' || temp[i] == 'Y')
                Ycount++;
        }
        if(Pcount != Ycount)
            answer = false; 

        return answer;
    }

}
