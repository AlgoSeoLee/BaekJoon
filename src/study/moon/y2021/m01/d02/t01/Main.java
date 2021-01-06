package study.moon.y2021.m01.d02.t01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;

//https://www.acmicpc.net/problem/12851    [G5]    숨바꼭질2
public class Main {

    static int[] visit;
    static LinkedList<Data> queue;
    static int answer = 0;
    static int endTime = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int k = Integer.parseInt(split[1]);
        visit = new int[100001];
        Arrays.fill(visit,-1);
        queue = new LinkedList<>();
        queue.offer(new Data(n, 0));

        while (!queue.isEmpty()) {
            Data poll = queue.poll();
            if (poll.time > endTime) {
                continue;
            }
            if (poll.position < 0 || poll.position > 100000) {
                continue;
            }
            if (visit[poll.position]!=-1) {
                if (poll.time != visit[poll.position]){
                    continue;
                }
            }
            if (poll.position == k) {
                answer++;
                endTime = poll.time;
            }
            visit[poll.position] = poll.time;
            queue.offer(new Data(poll.position - 1, poll.time + 1));
            queue.offer(new Data(poll.position + 1, poll.time + 1));
            queue.offer(new Data(poll.position * 2, poll.time + 1));
        }
        System.out.println(endTime);
        System.out.println(answer);
    }

}

class Data {

    int position;
    int time;

    public Data(int position, int time) {
        this.position = position;
        this.time = time;
    }
}
