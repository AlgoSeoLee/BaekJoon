package study.moon.d201105.t01;

import java.io.*;

//https://www.acmicpc.net/problem/6581
public class Main {
    public static void main(String[] args) throws IOException {
        //입력받은 문자열 하나로 통합
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str ="";
        StringBuilder builder = new StringBuilder();
        while ((str = br.readLine()) != null) {
            builder.append(str).append(" ");
        }

        //공백문자 중복 제거
        for (int i = 1; i < builder.length(); i++) {
            if(builder.charAt(i)=='\t') {
                builder.deleteCharAt(i);
                builder.append(" ");
            }
            if(builder.charAt(i - 1) == ' ' && builder.charAt(i) == ' ') {
                builder.deleteCharAt(i);
                i--;
            }
            if(builder.charAt(i)=='\n') {
                builder.deleteCharAt(i);
                builder.append(" ");
            }
            if(builder.charAt(i - 1) == ' ' && builder.charAt(i) == ' ') {
                builder.deleteCharAt(i);
                i--;
            }
        }

        //로직
        String[] split = builder.toString().split(" ");
        int letterCount = 0;
        builder = new StringBuilder();
        for (String s : split) {
            if(s.equals("<br>")) {
                builder.append("\n");
                letterCount = 0;
                continue;
            }
            if(s.equals("<hr>")) {
                if (builder.charAt(builder.length() - 1) != '\n') {
                    builder.append("\n");
                }
                builder.append("-".repeat(80));
                builder.append("\n");
                letterCount = 0;
                continue;
            }
            if(letterCount + s.length() > 80) {
                builder.append("\n");
                letterCount = 0;
            }
            builder.append(s).append(" ");
            letterCount+=(s.length()+1);
        }
        bw.write(builder.toString());
        bw.flush();
    }
}
