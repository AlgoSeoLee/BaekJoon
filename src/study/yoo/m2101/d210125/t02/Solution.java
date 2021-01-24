package study.yoo.m2101.d210125.t02;

//프로그래머스 땅따먹기
class Solution {
    int solution(int[][] land) {
        int answer = 0;

        for(int i = 1 ; i < land.length ; ++i){
            land[i][0] += Math.max(land[i - 1][1],
                          Math.max(land[i - 1][2], land[i - 1][3]));
            land[i][1] += Math.max(land[i - 1][0],
                          Math.max(land[i - 1][2], land[i - 1][3]));
            land[i][2] += Math.max(land[i - 1][0],
                          Math.max(land[i - 1][1], land[i - 1][3]));
            land[i][3] += Math.max(land[i - 1][0],
                          Math.max(land[i - 1][1], land[i - 1][2]));
        }
        
        for(int i = 0 ; i < 4 ; ++i){
            int value = land[land.length - 1][i];
            answer = value > answer ? value : answer;
        }

        return answer;
    }
}