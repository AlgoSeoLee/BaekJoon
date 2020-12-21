package study.moon.d201214.t03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
//https://www.acmicpc.net/problem/9375
public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());
            Map<String,Integer> map = new HashMap<>();
            for (int j = 0; j < m; j++) {
                String[] s = br.readLine().split(" ");
                map.put(s[1],map.getOrDefault(s[1],0)+1);
            }
            int answer = map
                .values()
                .stream()
                .mapToInt(v -> (v + 1))
                .reduce(1, (a, b) -> a * b) - 1;
            bw.write(answer+"\n");
        }
        bw.flush();
        bw.close();
    }
}
