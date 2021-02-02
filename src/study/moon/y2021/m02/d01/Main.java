package study.moon.y2021.m02.d01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    static boolean[] visited;
    static char[] output;
    static char[] arr;
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[1]);
        int r = Integer.parseInt(s[0]);
        arr = new char[n];
        s = br.readLine().split(" ");
        for (int i = 0; i < s.length; i++) {
            arr[i] = s[i].charAt(0);
        }
        Arrays.sort(arr);
        output = new char[n];
        visited = new boolean[n];

        permutation(0, n, r);
        bw.flush();
        bw.close();
        br.close();
    }

    //순열
    //사용 예시: permutation(arr, output, visited, 0, n, 3, answer);
    static void permutation(int depth, int n, int r) throws IOException {
        if (depth == r) {
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < r; i++) {
                str.append(output[i]);
            }
            if (!isRight(str)) {
                return;
            }
            bw.write(str.toString()+"\n");
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                permutation(depth + 1, n, r);
                visited[i] = false;
            }
        }
    }

    static boolean isRight(StringBuilder string) {
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == 'a' || string.charAt(i) == 'e' || string.charAt(i) == 'i' ||
                string.charAt(i) == 'o' || string.charAt(i) == 'u') {
                count1++;
            } else {
                count2++;
            }
        }
        for (int i = 0; i < string.length() - 1; i++) {
            if (string.charAt(i) > string.charAt(i + 1)) {
                return false;
            }
        }
        return count1 >= 1 && count2 >= 2;
    }
}
