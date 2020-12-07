package study.moon.d201207.t05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
//https://www.acmicpc.net/problem/10816
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<Integer, Integer> map = new HashMap<>();

        int n = Integer.parseInt(br.readLine());

        String[] split = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(split[i]);
            map.put(number, map.getOrDefault(number, 0) + 1);
        }

        int m = Integer.parseInt(br.readLine());

        split = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            bw.write(map.getOrDefault(Integer.parseInt(split[i]),0)+" ");
        }

        bw.flush();
        bw.close();
    }

}
