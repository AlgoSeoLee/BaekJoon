package study.eunwoo.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [2512 예산] https://www.acmicpc.net/problem/2512
public class B2512 {
    private static int n, m;
    private static int [] arr;
    private static int max, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(arr[i], max);
        }

        m = Integer.parseInt(br.readLine());

        binarySearch();

        System.out.println(result);
    }

    private static void binarySearch() {
        int low = 0;
        int high = max;
        int mid;

        while (low <= high) {
            mid = low + high >> 1;
            long sum = 0;

            for (int i = 0; i < n; i++) {
                sum += Math.min(mid, arr[i]);
            }

            if (sum <= m) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
    }
}
