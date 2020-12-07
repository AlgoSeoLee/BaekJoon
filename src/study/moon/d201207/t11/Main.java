package study.moon.d201207.t11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
//https://www.acmicpc.net/problem/11866
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int k = Integer.parseInt(split[1]);

        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.offer(i+1);
        }

        bw.write("<");
        while(queue.size()!=1) {
            for (int i = 0; i < k-1; i++) {
                queue.offer(queue.poll());
            }
            bw.write(queue.poll()+", ");
        }
        bw.write(queue.poll()+"");
        bw.write(">");

        bw.flush();
        bw.close();
    }
}
