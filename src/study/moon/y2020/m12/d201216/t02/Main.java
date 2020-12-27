package study.moon.y2020.m12.d201216.t02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
//https://www.acmicpc.net/problem/11279
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < T; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                if (maxHeap.isEmpty()) {
                    bw.write("0\n");
                }else {
                    bw.write(maxHeap.poll()+"\n");
                }
            } else {
                maxHeap.add(x);
            }
        }
        bw.flush();
        bw.close();
    }

}
