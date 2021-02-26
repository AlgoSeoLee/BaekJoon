package study.eunwoo.Baekjoon;

import java.util.Arrays;
import java.util.Scanner;

// [1920 수 찾기] https://www.acmicpc.net/problem/1920
public class B1920 {
    private static int [] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int m = sc.nextInt();

        for (int i = 0; i < m; i++) {
            int num = sc.nextInt();
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
                System.out.println(1);
                return;
            } else if (arr[mid] > key) {
                end = mid - 1;
            } else if (arr[mid] < key) {
                start = mid + 1;
            }
        }

        System.out.println(0);
    }
}
