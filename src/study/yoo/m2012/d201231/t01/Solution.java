package study.yoo.m2012.d201231.t01;

//전화번호 목록
//https://programmers.co.kr/learn/courses/30/lessons/42577
class Solution {
    public boolean solution(String[] phone_book) {
    	boolean answer = true;
    	
       for(int i=0; i<phone_book.length-1; i++) {
            for(int j=i+1; j<phone_book.length; j++) {
            	//startsWith() 함수 사용  <--> endtwith() 함수도 있음
            	//인수로 지정한 문자열로 시작하는 경우 True값 반환, 아니면 False 값을 반환.
                if(phone_book[i].startsWith(phone_book[j])) {return false;}
                if(phone_book[j].startsWith(phone_book[i])) {return false;}
            }
        }
       return answer;
    }
}