package study.moon.y2020.m10.d201026.t02;

import java.util.Arrays;
import java.util.Scanner;

// https://www.acmicpc.net/problem/1744
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        long ans =0;

        for (int i = 0; i <n ; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        int left = 0;
        int right = n-1;
        // 0, 음수일 경우 처리
        for (; left < right ; left+=2) {
            if(arr[left] <1 && arr[left+1] < 1){
                ans += arr[left] * arr[left+1];
            }else{
                break;
            }
        }
        // 양수일 경우 처리
        for (; right >0; right-=2) {
            // 1과는 곱하지 않게 조건문 추가.
            if(arr[right] >1 && arr[right-1] > 1){
                ans += arr[right] * arr[right-1];
            }else{
                break;
            }
        }
        //남은 값들은 더해주기
        for (; right >= left; right--) {
            ans += arr[right];
        }
        System.out.println(ans);
    }
}
