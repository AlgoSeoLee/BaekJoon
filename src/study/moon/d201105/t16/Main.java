package study.moon.d201105.t16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        String s = br.readLine();
        String[] split = s.split("[A-Za-z]");
        String[] strings = Arrays.stream(split)
                .filter(v -> !v.equals(""))
                .toArray(String[]::new);
        if(strings.length==0) {
            System.out.println(0);
            return;
        }
        for (String string : strings) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < string.length(); i++) {
                char c = string.charAt(i);
                if(c!='0') {
                    builder.append(c);
                }
            }
            string = builder.toString();
        }
        long answer = 0;
        for (String string : strings) {
            if (string.equals("")) {
                continue;
            }
            answer += Long.parseLong(string);
        }
        System.out.println(answer);
    }
}
