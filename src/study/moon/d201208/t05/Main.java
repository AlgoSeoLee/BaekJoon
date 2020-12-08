package study.moon.d201208.t05;

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
        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(br.readLine());
            if (number!=0) {
                stack.push(number);
            } else {
                stack.pop();
            }
        }
        int answer = 0;
        while (!stack.isEmpty()) {
            answer += stack.pop();
        }
        bw.write(answer+"");
        bw.flush();
        bw.close();
    }

}
