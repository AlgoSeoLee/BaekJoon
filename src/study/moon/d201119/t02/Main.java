package study.moon.d201119.t02;

import java.io.*;
import java.util.TreeSet;

//https://www.acmicpc.net/problem/1920
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        TreeSet<Integer> tree =new TreeSet<>();
        String[] split = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            tree.add(Integer.parseInt(split[i]));
        }
        int m = Integer.parseInt(br.readLine());
        split = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            if(tree.contains(Integer.parseInt(split[i]))) {
                bw.write("1"+"\n");
            } else {
                bw.write("0"+"\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
