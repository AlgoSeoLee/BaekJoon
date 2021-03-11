package study.moon.y2021.m03.d11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//https://www.acmicpc.net/problem/3613
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        if (isCpp(s)) {
            bw.write(toJava(s));
        } else if (isJava(s)) {
            bw.write(toCpp(s));
        } else {
            bw.write("Error!");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean isJava(String string) {
        for (int i = 0; i < string.length(); i++) {
            if ((string.charAt(i) < 'A' || string.charAt(i) > 'Z') && (string.charAt(i) < 'a'
                || string.charAt(i) > 'z')) {
                return false;
            }
        }
        return true;
    }

    private static boolean isCpp(String string) {
        for (int i = 0; i < string.length(); i++) {
            if ((string.charAt(i) != '_') && (string.charAt(i) < 'a' || string.charAt(i) > 'z')) {
                return false;
            }
        }
        return true;
    }

    private static String toJava(String s) {
        boolean toCapital = false;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '_') {
                toCapital = true;
            } else {
                if (toCapital) {
                    builder.append(Character.toString(s.charAt(i)).toUpperCase());
                    toCapital = false;
                } else  if (s.charAt(i)=='_') {
                    return "Error!";
                }else {
                    builder.append(s.charAt(i));
                }
            }
        }
        if (toCapital) {
            return "Error!";
        }
        return builder.toString();
    }

    private static String toCpp(String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >='A' && s.charAt(i) <='Z') {
                builder.append("_");
                builder.append(Character.toString(s.charAt(i)).toLowerCase());
            } else {
                builder.append(s.charAt(i));
            }
        }
        return builder.toString();
    }
}
