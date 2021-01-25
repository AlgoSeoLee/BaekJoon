package study.eunwoo.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//[8673. 코딩 토너먼트1] https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AW2Jldrqlo4DFASu&categoryId=AW2Jldrqlo4DFASu&categoryType=CODE
public class S8673 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int test=1; test<=t; test++) {
            int k = Integer.parseInt(br.readLine());

            int num = (int) Math.pow(2,k);
            List<Integer> list = new ArrayList<>();
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < num; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            int result = 0;
            num /= 2;

            for (int i = 0; i < k; i++) { // i=0, 1, 2
                for (int j = 0; j < num; j++) {
                    int a = list.get(j);
                    int b = list.get(j+1);

                    result += Math.abs(a-b);

                    if (a < b) {
                        list.remove(j);
                    } else {
                        list.remove(j+1);
                    }
                }

                num /= 2;
            }

            System.out.println("#"+test+" "+result);
        }
    }
}
