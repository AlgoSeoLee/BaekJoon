package study.moon.y2020.m12.d201224.t02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

//https://www.acmicpc.net/problem/1918
//후위표기식 스택
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        StringBuilder ans = new StringBuilder();
        Stack<Character> operators = new Stack<>();
        for (char ch : s.toCharArray()) {
            if ('A' <= ch && ch <= 'Z') {
                ans.append(ch);
            } else if (ch == '(') {
                operators.push(ch);
            } else if (ch == ')') {
                while (!operators.isEmpty()) {
                    char op = operators.pop();
                    if (op == '(') {
                        break;
                    }
                    ans.append(op);
                }
            } else {
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(ch)) {
                    ans.append(operators.pop());
                }
                operators.push(ch);
            }
        }
        while (!operators.isEmpty()) {
            ans.append(operators.pop());
        }
        bw.write(ans.toString());
        bw.flush();
        bw.close();
    }

    static int precedence(char ch) {
        if (ch == '(') {
            return 0;
        }
        if (ch == '+' || ch == '-') {
            return 1;
        } else {
            return 2;
        }
    }
}
