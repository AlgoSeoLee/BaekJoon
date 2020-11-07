package study.moon.d201105.t19;

import java.io.*;

//https://www.acmicpc.net/problem/14405
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] split = s.split("pi|ka|chu");
        if (split.length==0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
