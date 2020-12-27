package study.moon.y2020.m12.d201209.t02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<Integer> brokenButtons;

    public static void main(String[] args) throws IOException {
        //init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final int START_NUM = 100;

        int target = Integer.parseInt(br.readLine());
        int brokenBtnCnt = Integer.parseInt(br.readLine());
        brokenButtons = new ArrayList<>();

        if(brokenBtnCnt!=0) {
            String[] split = br.readLine().split(" ");
            for (int i = 0; i < brokenBtnCnt; i++) {
                brokenButtons.add(Integer.parseInt(split[i]));
            }
        }

        //logic

        int answer = Math.abs(target - START_NUM);

        for (int i = 0; i < 1_000_000; i++) {
            int length = getPossibleNumberLength(i);
            if (length != 0) {
                int number = Math.abs(target - i) + length;
                if (number < answer) {
                    answer = number;
                }
            }
        }
        bw.write(answer + "");

        bw.flush();
        bw.close();

    }

    private static int getPossibleNumberLength(int number) {
        if (number == 0) {
            return brokenButtons.contains(0) ? 0 : 1;
        }
        String s = String.valueOf(number);
        for (Integer brokenButton : brokenButtons) {
            if (s.contains(Integer.toString(brokenButton))) {
                return 0;
            }
        }
        return s.length();
    }

}
