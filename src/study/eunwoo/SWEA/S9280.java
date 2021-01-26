package study.eunwoo.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// [9280. 진용이네 주차타워] https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AW9j74FacD0DFAUY&categoryId=AW9j74FacD0DFAUY&categoryType=CODE
public class S9280 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int test=1; test<=t; test++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int [] r = new int[n+1]; // 주차 자리당 요금
            int [] w = new int[m+1]; // 자동차별 무게

            for (int i = 0; i < n; i++) {
                r[i] = Integer.parseInt(br.readLine());
            }

            for (int i = 0; i < m; i++) {
                w[i] = Integer.parseInt(br.readLine());
            }

            Queue<Integer> q = new LinkedList<>(); // 주차 출입 순서 큐
            Queue<Integer> tq = new LinkedList<>(); // 입구 대기 큐
            int [] p = new int[n]; // 주차장으로 이용할 배열

            for (int i = 0; i < 2*m; i++) {
                q.add(Integer.parseInt(br.readLine()));
            }

            int count = 0; // 차 갯수
            int result = 0;

            while (!q.isEmpty()) {
                int num;

                if (count < n && !tq.isEmpty()) { // 현재 차 갯수가 주차 공간 수 보다 적고, 입구 대기 큐에 차가 존재할 때
                    num = tq.poll();

                    for (int i = 0; i < n; i++) {
                        if (p[i] == 0) { // 주차장 빈 공간부터 채운다
                            p[i] = num;
                            result += r[i] * w[num-1];
                            count++;
                            break;
                        }
                    }
                } else { // 입구 대기 큐가 비었을 때
                    num = q.poll();

                    if (num > 0) {
                        if (count < n) {
                            for (int i = 0; i < n; i++) {
                                if (p[i] == 0) {
                                    p[i] = num;
                                    result += r[i] * w[num-1];
                                    count++;
                                    break;
                                }
                            }
                        } else { // 주차 공간 수 보다 들어오는 차가 더 많을 때 대기 큐에 추가
                            tq.add(num);
                        }
                    } else { // 주차장에서 차가 나가는 경우
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
