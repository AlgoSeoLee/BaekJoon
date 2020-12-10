package study.moon.test;

import java.io.IOException;
import java.util.Arrays;

//https://www.acmicpc.net/problem/10814
public class Main {

    public static void main(String[] args) throws IOException {
        String[] arr = {"128","My", "Name","IS","MunHyeok"};

        boolean matches = "128".matches("^[0-9]*$");
        System.out.println(matches);
    }
}

