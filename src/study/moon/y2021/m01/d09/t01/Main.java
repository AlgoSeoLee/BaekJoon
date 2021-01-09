package study.moon.y2021.m01.d09.t01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

//https://www.acmicpc.net/problem/16953    [S1]    A->B
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");

        long a = Long.parseLong(s[0]);
        long b = Long.parseLong(s[1]);

        Set<Long> set = new HashSet<>();

        LinkedList<Data> queue = new LinkedList<>();
        queue.add(new Data(a, 0));

        while (!queue.isEmpty()) {
            Data poll = queue.poll();
            if (poll.number >= 1_000_000_000) {
                continue;
            }
            if (set.contains(poll.number)) {
                continue;
            }
            if (poll.number == b) {
                bw.write(poll.count+1 + "");
                bw.flush();
                bw.close();
            }
            set.add(poll.number);
            queue.add(new Data(poll.number << 1, poll.count + 1));
            queue.add(new Data(poll.number * 10 + 1, poll.count + 1));
        }
        if (!set.contains(b)) {
            bw.write("-1");
            bw.flush();
            bw.close();
        }



    }
}

class Data {

    long number;
    int count;

    public Data(long number, int count) {
        this.number = number;
        this.count = count;
    }
}
