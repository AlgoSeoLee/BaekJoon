package study.yoo.m2101.d210121.t03;

import java.util.*;

// 입국심사
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;       
         Arrays.sort(times);
         long min = 1;
         long max = (long)times[times.length-1] * n; 
         long mid = 0;
         long sum;
         answer = max;
         while(min <= max){
             sum = 0;
             mid = (min + max) / 2;
             for(int time:times){
                 sum += mid / time;
             }
             if(sum >= n){
                 if(mid < answer){
                     answer = mid;
                 }
                 max = mid - 1;                
             }
             else{
                 min = mid + 1;
             }
         }
         return answer;
    }
}