package study.moon.d201214.t01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

//https://www.acmicpc.net/problem/9019
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            boolean[] visit = new boolean[10000];
            String answer = "";
            String[] split = br.readLine().split(" ");
            int start = Integer.parseInt(split[0]);
            int end = Integer.parseInt(split[1]);
            LinkedList<Data> queue = new LinkedList<>();
            queue.offer(new Data(doDouble(start), "D"));
            queue.offer(new Data(doSubtraction(start), "S"));
            queue.offer(new Data(doLeft(start), "L"));
            queue.offer(new Data(doRight(start), "R"));
            visit[start] = true;

            while (!queue.isEmpty()) {
                Data poll = queue.poll();
                if (poll.number == end) {
                    answer = poll.answer;
                    queue.clear();
                    break;
                }
                System.out.println(poll.number);
                if (visit[poll.number]) {
                    continue;
                }
                visit[poll.number] = true;
                queue.offer(new Data(doDouble(poll.number), poll.answer + "D"));
                queue.offer(new Data(doSubtraction(poll.number), poll.answer + "S"));
                queue.offer(new Data(doLeft(poll.number), poll.answer + "L"));
                queue.offer(new Data(doRight(poll.number), poll.answer + "R"));
            }
            bw.write(answer + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static int doDouble(int number) {
        number *= 2;
        if (number >= 10000) {
            number %= 10000;
            return number;
        }
        return number;
    }

    private static int doRight(int number) {
        int tmp = number % 10;
        number /= 10;
        number += tmp * 1000;
        return number;
    }

    private static int doLeft(int number) {
        int tmp = number / 1000;
        number = number * 10 % 10000 + tmp;

        return number;
    }

    private static int doSubtraction(int number) {
        if (number == 0) {
            number = 9999;
        } else {
            number--;
        }
        return number;
    }
}

class Data {

    int number;
    String answer;

    public Data(int number, String answer) {
        this.number = number;
        this.answer = answer;
    }
}
