package study.yoo.d201109.t04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//https://www.acmicpc.net/problem/10809
public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int[] alpha = new int[26];
        Arrays.fill(alpha, -1);

        for (int i = 0; i < line.length(); i++)
            if(alpha[line.charAt(i) - 'a']==-1)
                alpha[line.charAt(i) - 'a'] = i;

        for(int num: alpha)
            System.out.print(num+" ");

    }
}