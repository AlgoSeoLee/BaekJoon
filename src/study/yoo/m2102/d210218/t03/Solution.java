package study.yoo.m2102.d210218.t03;

import java.util.ArrayList;
import java.util.List;

// 영어 끝말잇기 2
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        List<String> list = new ArrayList<String>();
        
        for(int i = 0; i < words.length; i++){
            if(i > 0 && words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0) || list.contains(words[i])){   // 끝말잇기가 아니거나 예전에 등장한 단어인 경우
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                break;
            }
            
            list.add(words[i]); 
        }
        return answer;
    }
}