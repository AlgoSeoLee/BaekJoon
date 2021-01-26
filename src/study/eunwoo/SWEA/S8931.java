package study.eunwoo.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// [8931 제로] https://swexpertacademy.com/main/code/problem/problemSolver.do?contestProbId=AW5jBWLq7jwDFATQ
public class S8931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int test=1; test<=t; test++) {
            int k = Integer.parseInt(br.readLine());
            Stack<Integer> s = new Stack<>();

            for (int i = 0; i < k; i++) {
                int tmp = Integer.parseInt(br.readLine());

                if (tmp != 0) {
                    s.push(tmp);
                } else {
                    s.pop();
                }
            }

            int sum = 0;

            while (!s.isEmpty()) {
                sum += s.pop();
            }

            System.out.println("#"+test+" "+sum);
        }
    }
}
