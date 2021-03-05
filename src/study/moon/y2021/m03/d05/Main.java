package study.moon.y2021.m03.d05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


/*
소마코테 토지개발
8
1 3 10 9 6 2 3 2
*/
public class Main {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String[] split = br.readLine().split(" ");
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }

        bw.write(solution(0, N - 1, 0)+"");

        bw.flush();
        bw.close();
        br.close();

    }

    private static int solution(int start, int end, int answer) {
        if (start == end) {
            return answer;
        }
        int mid = (start + end) / 2;

        int left = Integer.MIN_VALUE;
        for (int i = start; i <= mid; i++) {
            if (arr[i] > left) {
                left = arr[i];
            }
        }

        int right = Integer.MIN_VALUE;
        for (int i = mid + 1; i <= end; i++) {
            if (arr[i] > right) {
                right = arr[i];
            }
        }

        if (left > right) {
            return solution(mid + 1, end, answer + left);
        } else if (left < right) {
            return solution(start, mid, answer + right);
        } else {
            return Math.max(
                solution(mid + 1, end, answer + left),
                solution(start, mid, answer + right)
            );
        }
    }
}
