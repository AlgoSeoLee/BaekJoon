package study.moon.d201211.t02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

//https://www.acmicpc.net/problem/1931
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Time[] times = new Time[n];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            times[i] = (new Time(Integer.parseInt(s[0]),Integer.parseInt(s[1])));
        }

        Arrays.sort(times);
        int end = 0;
        int answer = 0;
        for (Time time : times) {
            if (time.start >= end) {
                end = time.end;
                answer++;
            }
        }
        bw.write(answer+"");
        bw.flush();
        bw.close();

    }

}

class Time implements Comparable<Time> {
    int start;
    int end;

    public Time(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Time o) {
        if(end > o.end) {
            return 1;
        } else if(end == o.end) {
            if(start > o.start) {
                return 1;
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    }
}
