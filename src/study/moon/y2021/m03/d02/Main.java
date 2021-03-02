package study.moon.y2021.m03.d02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/*
소마코테 [땅콩먹기] - 투포인터
6 3 7
2 4 5 8 11 12
 */
public class Main {

    static List<Integer> list;
    static int N;
    static int M;
    static int E;
    static int start;
    static int end;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        E = Integer.parseInt(s[2]);

        s = br.readLine().split(" ");
        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(s[i]));
        }

        setMyPlace();
        solution();

        bw.write(list.get(end) - list.get(start) + "");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void solution() {
        while (count != M) {
            if (start == 0) {
                end = end + 1;
            } else if (end == N - 1) {
                start = start - 1;
            } else {
                if (list.get(start) - list.get(start - 1) >= list.get(end + 1) - list.get(end)) {
                    end = end + 1;
                } else {
                    start = start - 1;
                }
            }
            count++;
        }
    }

    private static void setMyPlace() {
        for (int i = 0; i < N; i++) {
            if (list.get(i) > E) {
                list.add(i, E);
                start = i;
                end = i;
                break;
            } else if (list.get(i) == E) {
                count++;
                start = i;
                end = i;
                break;
            }
        }
    }
}
