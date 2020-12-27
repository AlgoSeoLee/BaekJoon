package study.moon.y2020.m12.d201207.t17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
//https://www.acmicpc.net/problem/2108
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        System.out.println(getSanSul(arr));
        System.out.println(getMiddle(arr));
        System.out.println(getMostFrequency(arr));
        System.out.println(getRange(arr));


    }

    public static String getSanSul(int[] arr) {
        int answer = 0;
        for (int j : arr) {
            answer += j;
        }
        double result = (double)answer / arr.length;

        return String.valueOf(Math.round(result));
    }

    public static int getMiddle(int[] arr) {
        return arr[arr.length/2];
    }

    public static int getMostFrequency(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int j : arr) {
            map.put(j, map.getOrDefault(j, 0) + 1);
        }
        Integer[] keys = map.keySet().toArray(Integer[]::new);
        Integer[] values = map.values().toArray(Integer[]::new);
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        for (int i = 0; i < values.length; i++) {
            if(values[i]>=max) {
                max = values[i];
                maxIndex = i;
            }
        }
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < values.length; i++) {
            if(values[i] == max) {
                answer.add(keys[i]);
            }
        }

        if(answer.size()>=2) {
            return answer.stream().sorted().collect(Collectors.toList()).get(1);
        }
        return keys[maxIndex];
    }

    public static int getRange(int[] arr) {
        return arr[arr.length-1] - arr[0];
    }

}
