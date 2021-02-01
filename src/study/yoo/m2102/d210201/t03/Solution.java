package study.yoo.m2102.d210201.t03;

import java.util.*;

//점프와 순간이동
public class Solution {
    public int solution(int n) {
        int ans = 0;
        while (n != 0) { 
            if(n % 2 == 0){
                n /= 2;
            } else { 
                ans++;
                n--;
            }
        }
        return ans;
    }
}
