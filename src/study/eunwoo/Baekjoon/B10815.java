package study.eunwoo.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// [10815 숫자 카드] https://www.acmicpc.net/problem/10815
public class B10815 {
    private static int [] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            binarySearch(n, num);
        }
    }

    private static void binarySearch(int n, int key) {
        int start = 0;
        int end = n-1;
        int mid;

        while (end - start >= 0) {
            mid = (start + end) / 2;

            if (arr[mid] == key) {
                System.out.print(1+" ");
                return;

            } else if (arr[mid] > key) {
                end = mid - 1;

            } else if (arr[mid] < key) {
                start = mid + 1;

            }
        }

        System.out.print(0+" ");
    }
}
