package study.eunwoo.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S6808 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int test=1; test<=t; test++) {
            st = new StringTokenizer(br.readLine());

            int [] card = new int[9];

            for (int i = 0; i < card.length; i++) {
                card[i] = Integer.parseInt(st.nextToken());
            }

            

        }
    }
}
