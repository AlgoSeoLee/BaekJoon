package study.eunwoo.SWEA;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// [9280 진용이네 주차타워] https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AW9j74FacD0DFAUY&categoryId=AW9j74FacD0DFAUY&categoryType=CODE
public class S9280 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int test=1; test<=t; test++) {
            int n = sc.nextInt(); // 주차 공간 갯수
            int m = sc.nextInt(); // 들어오는 차 갯수

            int [] r = new int[n+1]; // 주차 공간의 단위 무게당 요금
            int [] w = new int[m+1]; // 차량의 무게

            for (int i=0; i<n; i++) {
                r[i] = sc.nextInt();
            }

            for (int i=0; i<m; i++) {
                w[i] = sc.nextInt();
            }

            Queue<Integer> q = new LinkedList<>();
            Queue<Integer> tq = new LinkedList<>(); // 대기장소를 나타낼 임시의 큐

            int [] p = new int[n]; // 주차장으로 사용할 배열
            int count = 0; // 주차장에 있는 차 갯수
            int result = 0;

            for (int i=0; i<2*m; i++) {
                q.add(sc.nextInt());
            }

            while (!q.isEmpty()) {
                int num;

                if (count < n && !tq.isEmpty()) { // 주차장 현재 차 갯수가 n보다 작고, 대기장소에 차가 존재할 때
                    num = tq.poll();

                    for (int i = 0; i < n; i++) {
                        if (p[i] == 0) {
                            p[i] = num;
                            result += w[num-1] * r[i];
                            count++;
                            break;
                        }
                    }
                } else {
                    num = q.poll();

                    if (num > 0) {
                        if (count < n) {
                            for (int i = 0; i < n; i++) {
                                if (p[i] == 0) {
                                    p[i] = num;
                                    result += w[num-1] * r[i];
                                    count++;
                                    break;
                                }
                            }
                        } else {
                            tq.add(num);
                        }
                    } else {
                        num *= -1;

                        for (int i = 0; i < n; i++) {
                            if (p[i] == num) {
                                p[i] = 0;
                                count--;
                            }
                        }
                    }
                }
            }

            System.out.println("#"+test+" "+result);
        }
    }
}
