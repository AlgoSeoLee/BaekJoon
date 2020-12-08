package study.moon.d201208.t06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
//https://www.acmicpc.net/problem/11651
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Data[] data = new Data[n];

        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split(" ");
            data[i] = new Data(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
        }

        Arrays.sort(data);

        for (int i = 0; i < n; i++) {
            bw.write(data[i].x + " " + data[i].y + "\n");
        }
        bw.flush();
        bw.close();
    }

}

class Data implements Comparable<Data> {

    int x;
    int y;

    public Data(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Data o) {
        if (this.y > o.y) {
            return 1;
        } else if (y == o.y) {
            if (x > o.x) {
                return 1;
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    }
}
