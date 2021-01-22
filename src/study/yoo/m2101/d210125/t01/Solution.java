package study.yoo.m2101.d210125.t01;

class Solution {
    public int solution(int n) {
        
        String nBi = Integer.toBinaryString(n); // n 이진수화
        int count = Integer.bitCount(n);
        
            for(int i = n+1; ; i++){ 
                String mBi = Integer.toBinaryString(i);
                
            if(count == Integer.bitCount(i)) 
               return i;
      }
        
    }
}


