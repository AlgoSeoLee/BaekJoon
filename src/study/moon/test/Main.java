package study.moon.test;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] strings = new String[10];
        strings[0] = "14253";
        strings[1] = "124515";
        strings[2] = "123";
        strings[3] = "1420";
        strings[4] = "141343145";
        strings[5] = "16234";
        strings[6] = "151236123";
        strings[7] = "15029892";
        strings[8] = "23415222";
        strings[9] = "154292388";
        Arrays.sort(strings);
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
