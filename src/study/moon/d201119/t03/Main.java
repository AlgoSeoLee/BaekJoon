package study.moon.d201119.t03;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//https://www.acmicpc.net/problem/1697
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] Min = new int[100005];
        Arrays.fill(Min, -1);
        System.out.println(BFS(N, K, Min));

    }

    public static int BFS(int N, int K, int[] Min) {
        int nextN = N;
        int[] status = new int[3];
        Queue<Integer> q = new LinkedList<>();
        q.add(nextN);
        Min[nextN] = 0;

        while (!q.isEmpty() && nextN != K) {
            nextN = q.poll();
            status[0] = nextN - 1;
            status[1] = nextN + 1;
            status[2] = nextN * 2;

            for (int i = 0; i < 3; i++) {
                if (status[i] >= 0 && status[i] <= 100000) {
                    if (Min[status[i]] == -1) {
                        q.add(status[i]);
                        Min[status[i]] = Min[nextN] + 1;
                    }
                }
            }
        }
        return Min[K];
    }
}

