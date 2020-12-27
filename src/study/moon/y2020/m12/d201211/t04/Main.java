package study.moon.y2020.m12.d201211.t04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        a:
        for (int i = 0; i < T; i++) {
            String query = br.readLine();
            int n = Integer.parseInt(br.readLine());
            boolean isReversed = false;
            StringBuilder builder = new StringBuilder(br.readLine());
            builder.deleteCharAt(0);
            builder.deleteCharAt(builder.length() - 1);
            if (n == 0) {
                for (int j = 0; j < query.length(); j++) {
                    if (query.charAt(j)=='D') {
                        bw.write("error\n");
                        continue a;
                    }
                }
                bw.write("[]\n");
                continue ;
            }
            String[] split = builder.toString().split(",");
            Deque<String> deque = new ArrayDeque<>(Arrays.asList(split));
            for (int j = 0; j < query.length(); j++) {
                if (query.charAt(j) == 'R') {
                    isReversed = !isReversed;
                }
                if (query.charAt(j) == 'D') {
                    if (deque.size() == 0) {
                        bw.write("error\n");
                        continue a;
                    } else {
                        if (isReversed) {
                            deque.pollLast();
                        } else {
                            deque.pollFirst();
                        }
                    }
                }
            }
            bw.write("[");
            if (deque.size()!=0) {
                if (!isReversed) {
                    while(deque.size()!=1) {
                        bw.write(deque.pollFirst() + ",");
                    }
                    bw.write(deque.pollFirst() + "");

                } else {
                    while(deque.size()!=1) {
                        bw.write(deque.pollLast() + ",");
                    }
                    bw.write(deque.pollLast() + "");
                }
            }
            bw.write("]\n");
        }
        bw.flush();
        bw.close();
    }
}

