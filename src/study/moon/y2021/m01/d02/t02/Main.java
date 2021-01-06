package study.moon.y2021.m01.d02.t02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

//https://www.acmicpc.net/problem/13549    [G5]    숨바꼭질3
public class Main {

    static boolean[] visit;
    static PriorityQueue<Data> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int k = Integer.parseInt(split[1]);
        visit = new boolean[100001];
        queue = new PriorityQueue<>();
        queue.offer(new Data(n, 0));

        while (!queue.isEmpty()) {
            Data poll = queue.poll();
            if (poll.position < 0 || poll.position > 100000) {
                continue;
            }
            if (visit[poll.position]) {
                continue;
            }
            if (poll.position==k) {
                System.out.println(poll.time);
                break;
            }
            visit[poll.position] = true;
            queue.offer(new Data(poll.position * 2, poll.time));
            queue.offer(new Data(poll.position - 1, poll.time + 1));
            queue.offer(new Data(poll.position + 1, poll.time + 1));
        }
    }

}

class Data implements Comparable<Data> {

    int position;
    int time;

    public Data(int position, int time) {
        this.position = position;
        this.time = time;
    }

    @Override
    public int compareTo(Data o) {
        return this.time-o.time;
    }
}
