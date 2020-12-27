package study.moon.y2020.m12.d201211.t01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

//https://www.acmicpc.net/problem/1927
public class Main {

    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x == 0) {
                if(heap.isEmpty()) {
                    bw.write("0\n");
                } else {
                    bw.write(heap.poll()+"\n");
                }
            }else {
                heap.add(x);
            }
        }
        bw.flush();
        bw.close();
    }

}
