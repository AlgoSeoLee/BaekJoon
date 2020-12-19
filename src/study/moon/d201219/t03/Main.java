package study.moon.d201219.t03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] arr = new int[n];
        int[] tmp = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
            tmp[i] = Integer.parseInt(s[i]);
        }

        Arrays.sort(tmp);

        Map<Integer,Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(tmp[i])) {
                map.put(tmp[i],count);
                count++;
            }
        }

        for (int i = 0; i < n; i++) {
            bw.write(map.get(arr[i])+" ");
        }
        bw.flush();
        bw.close();

    }
}
