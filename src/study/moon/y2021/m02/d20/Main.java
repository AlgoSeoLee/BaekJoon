package study.moon.y2021.m02.d20;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//https://www.acmicpc.net/problem/17609    [S1]    회문
public class Main {
    static String string;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        for (String s : arr) {
            int count = 0;
            int start = 0;
            int end = s.length() - 1;
            string = s;
            int answer = dfs(start,end,count);
            bw.write(answer+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static int dfs(int start, int end, int count) {
        if (start>end) {
            return count;
        }
        if (count == 2) {
            return count;
        }
        if (string.charAt(start)!=string.charAt(end)) {
            if (count == 0) {
                int a = 0, b = 0;
                if (string.charAt(start+1) == string.charAt(end)) {
                    a = dfs(start+1,end,count+1);
                }
                if (string.charAt(start) == string.charAt(end-1)) {
                    b = dfs(start,end-1,count+1);
                }
                if (a==1||b==1) {
                    return 1;
                } else {
                    return 2;
                }
            }
            else {
                return 2;
            }
        } else {
            return dfs(start+1,end-1,count);
        }
    }
}
