package study.eunwoo.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// [10816 숫자 카드 2] https://www.acmicpc.net/problem/10816
public class B10816 {
    private static int n;
    private static int [] cards;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        cards = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cards);

        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            int k = Integer.parseInt(st.nextToken());
            int upper = upperBound(k);
            int lower = lowerBound(k);

            sb.append(upper-lower).append(" ");
        }

        System.out.println(sb);
    }

    private static int lowerBound(int key) {
        int start = 0;
        int end = n-1;
        int mid;

        while (start < end) {
            mid = start + end >> 1;

            if (cards[mid] >= key) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return end;
    }

    private static int upperBound(int key) {
        int start = 0;
        int end = n-1;
        int mid;

        while (start < end) {
            mid = start + end >> 1;

            if (cards[mid] > key) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        if (cards[end] == key) end++;
        return end;
    }
}
