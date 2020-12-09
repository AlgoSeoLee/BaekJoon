package study.moon.test;

import java.io.IOException;
import java.util.Arrays;

//https://www.acmicpc.net/problem/10814
public class Main {

    public static void main(String[] args) throws IOException {
        String[] arr = {"Hello","My", "Name","IS","MunHyeok"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr,(o1,o2)-> {//양수면 자리를 바꾼다?
            return o2.length() - o1.length();
        });

        System.out.println(Arrays.toString(arr));
    }
}

