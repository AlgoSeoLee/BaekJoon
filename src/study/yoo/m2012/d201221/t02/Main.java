package study.yoo.m2012.d201221.t02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

//최소힙
//https://www.acmicpc.net/problem/1927
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 0; i < N; i++){
            int a = Integer.parseInt(br.readLine());
            if(a == 0){
                if (queue.isEmpty()) {
                    bw.write("0\n");
                 } else {
                    bw.write(queue.poll() + "\n");
                 }
            } else {
                queue.add(a);
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}