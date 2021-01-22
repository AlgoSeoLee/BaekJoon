package study.eunwoo.SWEA;

import java.util.*;

// [9229 한빈이와 Spot Mart] https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AW8Wj7cqbY0DFAXN&categoryId=AW8Wj7cqbY0DFAXN&categoryType=CODE
public class S9229 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int test=1; test<=t; test++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int [] arr = new int[n];

            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            Arrays.sort(arr);

            List<Integer> list = new ArrayList<>();

            int len = arr.length;

            for (int i = 0; i < len; i++) {
                for (int j = len-1; j>=i ; j--) {
                    if (i == j) break;

                    if (arr[i] + arr[j] <= m) {
                        list.add(arr[i] + arr[j]);
                    }
                }
            }

            list.sort(Collections.reverseOrder());

            if (list.size() == 0) {
                System.out.println("#"+test+" "+ (-1));
            } else {
                System.out.println("#"+test+" "+ list.get(0));
            }
        }
    }
}
