package study.yoo.d201228.t01;

//프로그래머스 큰 수 만들기
class Solution {
    public String solution(String number, int k) {
    	
        StringBuilder sb = new StringBuilder(number);
        int del_count = 0;
        int index = 1;
        
        while(del_count != k) {
            //전의 숫자랑 비교해서 더 크면 전의 숫자를 삭제하고 크기가 줄어들었으므로 index를 줄임
            if(index>=1 && sb.charAt(index) > sb.charAt(index-1)) {
                sb.deleteCharAt(index-1);
                index--;
                del_count++;
            } else {
                //index가 맨 끝으로 가고, 그 전의 숫자와 작거나 같으면 지금의 숫자를 삭제해준다.
                if(index==sb.length()-1 && sb.charAt(index) <= sb.charAt(index-1)) {
                    sb.deleteCharAt(index);
                    del_count++;
                    index--;
                } else {
                //그 외의 경우에는 index를 추가해준다.
                index++;
                }
            }
        }      
        return sb.toString();
    }
}
