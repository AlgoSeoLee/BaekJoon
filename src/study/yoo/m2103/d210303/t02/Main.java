package study.yoo.m2103.d210303.t02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 콘도 선정 2246
// https://www.acmicpc.net/problem/2246
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		int[][] condos = new int[a][2];

		for (int i = 0; i < a; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			condos[i][0] = Integer.parseInt(st.nextToken()); // 바닷가로부터 거리
			condos[i][1] = Integer.parseInt(st.nextToken()); // 숙박비
		}

		int count = 0;

		for (int i = 0; i < a; i++) {
			boolean flag = true;
			for (int j = 0; j < a; j++) {

				if (i == j)
					continue; // x자신은 비교안함

				if (condos[i][0] >= condos[j][0]) { 
					if (condos[i][1] >= condos[j][1]) { 
						flag = false;
						break;
					}
				}

				if (condos[i][1] >= condos[j][1]) { 
					if (condos[i][0] >= condos[j][0]) { 
						flag = false;
						break;
					}
				}
			}
			if (flag) {
				count++;
			}
		}
		System.out.println(count);
	}
}
