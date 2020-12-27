package study.moon.y2020.m11.d201126.t01;

import java.io.*;
import java.util.Arrays;

// https://www.acmicpc.net/problem/2805
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");
        int n = Integer.parseInt(strings[0]);
        int m = Integer.parseInt(strings[1]);

        String[] split = br.readLine().split(" ");
        int[] arr = new int[n];
        for(int i = 0; i < split.length ; i++){
            arr[i] = Integer.parseInt(split[i]);
        }

        Arrays.sort(arr);

        int max = arr[n - 1];
        int min = 0;
        int mid;

        while(max >= min){
            mid = (min + max) / 2;
            int cutTree;
            long sumCutTree = 0;
            for (int i : arr) {
                cutTree = i - mid;
                if (cutTree < 0) {
                    cutTree = 0;
                }
                sumCutTree += cutTree;
            }
            if(sumCutTree >= m){
                min = mid + 1;
            }else if(sumCutTree < m){
                max = mid - 1;
            }
        }
        System.out.println(max);
    }

}
