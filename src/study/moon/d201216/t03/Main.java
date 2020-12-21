package study.moon.d201216.t03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
//https://www.acmicpc.net/problem/11286
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> {
            int a1 = Math.abs(o1);
            int a2 = Math.abs(o2);

            if (a1 < a2) {
                return -1;
            } else if (a1 > a2) {
                return 1;
            } else {
                if (o1 < o2) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
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
