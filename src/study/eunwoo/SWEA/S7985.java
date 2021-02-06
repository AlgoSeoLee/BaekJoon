package study.eunwoo.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// [7985. Rooted Binary Tree 재구성] https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWu1JmN6Js4DFASy
public class S7985 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int test=1; test<=t; test++) {
            int k = Integer.parseInt(br.readLine());
            int n = (int) Math.pow(2, k) - 1;

            st = new StringTokenizer(br.readLine());

            List<Integer> list = new ArrayList<>();
            List<Integer> answer = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            while (list.size() != 0) {
                List<Integer> temp = new ArrayList<>();

                for (int i = 0; i < list.size(); i+=2)
                    temp.add(list.get(i));

                for (Integer i: temp)
                    list.remove(i);

                Collections.reverse(temp);
                answer.addAll(temp);
            }

            Collections.reverse(answer);

            System.out.print("#"+test+" ");
            for (int i = 0, j = 0; i < answer.size(); i++) {
                System.out.print(answer.get(i) + " ");

                if (i == j) {
                    System.out.println();
                    j = (2 * j) + 2;
                }
            }
        }
    }
}
