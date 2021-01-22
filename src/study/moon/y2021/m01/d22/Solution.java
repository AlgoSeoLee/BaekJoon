package study.moon.y2021.m01.d22;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXAdrmW61ssDFAXq&categoryId=AXAdrmW61ssDFAXq&categoryType=CODE&&&
//[D3]
//민정이와 광직이의 알파벳 공부
public class Solution {
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] arr = new String[n];
            int[] visited = new int[26];
            for (int j = 0; j < n; j++) {
                arr[j] = br.readLine();
            }
            count = 0;
            for (int r = 1; r <= n; r++) {
                combination(arr, visited, 0, n, r);
            }
            bw.write("#"+(i+1)+" "+count+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    //조합
    static void combination(String[] arr, int[] visited, int start, int n, int r) {
        if (r == 0) {
            if (isFinished(visited)) {
                count++;
            }
            return;
        }

        for (int i = start; i < n; i++) {
            checkAlphabet(arr,visited,i);
            combination(arr, visited, i + 1, n, r - 1);
            unCheckAlphabet(arr,visited,i);
        }
    }

    static void checkAlphabet(String[] arr, int[] visited, int n) {
        for (char c : arr[n].toCharArray()) {
            visited[c-'a']++;
        }
    }

    static void unCheckAlphabet(String[] arr, int[] visited, int n) {
        for (char c : arr[n].toCharArray()) {
            visited[c-'a']--;
        }
    }

    static boolean isFinished(int[] visited) {
        for (int i = 0; i < 26; i++) {
            if (visited[i]==0) {
                return false;
            }
        }
        return true;
    }
}
