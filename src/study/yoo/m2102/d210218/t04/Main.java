package study.yoo.m2102.d210218.t04;

//정수삼각형 3
class Solution {

    public int solution(int[][] triangle) {

        for(int i = triangle.length - 2; i >= 0; i--){
            for(int j = 0; j < triangle[i].length; j++){
                triangle[i][j] = triangle[i+1][j] > triangle[i+1][j+1] ? triangle[i][j] + triangle[i+1][j] : triangle[i][j]+ triangle[i+1][j+1];
            }
        }
        return triangle[0][0];
    }
}