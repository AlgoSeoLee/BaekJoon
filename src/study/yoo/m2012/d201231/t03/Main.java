package study.yoo.m2012.d201231.t03;

import java.util.Scanner;

//https://www.acmicpc.net/problem/11478
public class Main{
   public static void main(String[] agrs){
       Scanner sc = new Scanner(System.in);
       
       String problem = sc.nextLine();
       char[] div_pro = problem.toCharArray();
   
       int count = 0;
       
       for(int i=div_pro.length-1; i>=0; i--){
           for(int j=i; j<div_pro.length; j++){
        	   //선택한 문자 뒤~끝까지 문자열
               String temp1 = problem.substring(i+1);
               //부분문자열
               String temp2 = problem.substring(i, j+1);
               
               System.out.println(temp1);
               System.out.println(temp2 + "몰랑");
               //중복된거 빼고 카운트
               if(temp1.contains(temp2)) {
            	   continue;
               }
               else {
            	   count++;    
               }
           }
       }
       System.out.println(count);
       sc.close();
   }
}



