package study.moon.d201219.t04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
//https://www.acmicpc.net/problem/1043
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        long min = Long.parseLong(s[0]);
        long max = Long.parseLong(s[1]);

        boolean[] check = new boolean[(int) (max - min) + 1];

        for (long i = 2; i <= Math.sqrt(max); i++) {
            long square = i * i;
            long start;
            if (min % square == 0) {
                start = min / square;
            } else {
                start = min / square + 1;
            }
            //핵심문장
            for (long j = start; j * square <= max; j++) {
                check[(int) (j * square - min)] = true;
            }
        }

        int count = 0;
        for (int i = 0; i < (int) (max - min) + 1; i++) {
            if (!check[i]) {
                count++;
            }
        }
        bw.write(count+"");
        bw.flush();
        bw.close();
    }
}
