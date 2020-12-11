package study.moon.test;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;

//https://www.acmicpc.net/problem/10814
public class Main {

    public static void main(String[] args) throws IOException {
        ArrayDeque<Integer> list = new ArrayDeque<>();
        String[] arr ={"1","1","2","3","5","8"};
        arr = reverse(arr);
        arr = reverse(arr);
        arr = delete(arr);
        System.out.println(Arrays.toString(arr));
    }
    private static String[] delete(String[] split) {
        String[] arr = new String[split.length - 1];
        if (arr.length >= 0) {
            System.arraycopy(split, 1, arr, 0, arr.length);
        }
        return arr;
    }

    private static String[] reverse(String[] split) {
        String[] arr = new String[split.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = split[split.length - 1 - i];
        }
        return arr;
    }
}

