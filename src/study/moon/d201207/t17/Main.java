package study.moon.d201207.t17;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);



    }

    public static int getSanSul(int[] arr) {
        int answer = 0;
        for (int j : arr) {
            answer += j;
        }
        return answer/ arr.length;
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
        for (int i = 0; i < keys.length; i++) {
            if(keys[i]>max) {
                max = keys[i];
                maxIndex = i;
            }
        }
        return values[max];
    }

    public static int getRange(int[] arr) {
        return arr[arr.length-1] - arr[0];
    }

}
