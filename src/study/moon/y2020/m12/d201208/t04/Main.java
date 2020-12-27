package study.moon.y2020.m12.d201208.t04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = "";
        while(!(s = br.readLine()).equals(".")){
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                int c = s.charAt(i);
                if(c =='(' || c ==')' ||c =='['||c ==']') {
                    if(stack.isEmpty()) {
                        stack.push(c);
                    }else if(stack.peek()=='(' && c ==')') {
                        stack.pop();
                    }else if(stack.peek()=='[' && c ==']') {
                        stack.pop();
                    }else {
                        stack.push(c);
                    }
                }
            }
            if (stack.isEmpty()) {
                bw.write("yes\n");
            } else {
                bw.write("no\n");
            }
        }
        bw.flush();
        bw.close();
    }

}
