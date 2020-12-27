package study.moon.y2020.m11.d201105.t18;

import java.io.*;

//https://www.acmicpc.net/problem/1110
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        int count = 0;
        String answer = s;
        if(s.length()==1) {
            s = "0"+s;
            answer = s;
        }
        while(true) {
            String newNumber = Integer.toString(Character.getNumericValue(s.charAt(0))+Character.getNumericValue(s.charAt(1)));
            s = Character.toString(s.charAt(1))+newNumber.charAt(newNumber.length()-1);
            if (s.equals(answer)) {
                break;
            }
            count++;
        }
        System.out.println(count+1);
    }
}
