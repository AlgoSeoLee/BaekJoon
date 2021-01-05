package study.eunwoo.SWEA;

import java.util.Scanner;

public class S1859 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int i=0; i<T; i++) {
            int N = sc.nextInt();
            int array [] = new int[N];

            for (int j=0; j<N; j++)
                array[j] = sc.nextInt();
            Long sum = 0L;
            int maxValue = array[N-1];

            for (int z=N-2; z>=0; z--) {
                if (array[z] > maxValue) maxValue = array[z];
                else sum += maxValue - array[z];
            }

            System.out.format("#%d %d\n", (i+1), sum);
        }
    }
}
