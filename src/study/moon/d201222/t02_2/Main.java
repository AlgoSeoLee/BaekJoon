package study.moon.d201222.t02_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//https://www.acmicpc.net/problem/1629
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] split = br.readLine().split(" ");
        long a = Long.parseLong(split[0]);
        long b = Long.parseLong(split[1]);
        long c = Long.parseLong(split[2]);

        bw.write(getAnswer(a,b,c)+"");
        bw.flush();
        bw.close();
    }

    private static long getAnswer(long a, long b, long c) {
        if (b==1) {
            return a%c;
        }
        long answer = getAnswer(a, b / 2, c);
        if (b%2==1) {
            return answer * answer % c * a % c;
        } else {
            return answer * answer % c;
        }
    }

}
