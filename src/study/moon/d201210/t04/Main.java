package study.moon.d201210.t04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;

public class Main {

    static int a = 0;
    static int b = 0;
    static int c = 0;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }
        int numbers = getNumbers(0, 0, n);
        if (numbers==-2) {
            System.out.println(a);
            System.out.println(b);
            System.out.println(c);
        }else {
            if (numbers == -1) {
                a++;
            } else if(numbers == 0) {
                b++;
            } else {
                c++;
            }
            System.out.println(a);
            System.out.println(b);
            System.out.println(c);
        }
    }

    private static int getNumbers(int startX, int startY, int size) {
        size /= 3;
        if (size == 0) {
            return arr[startX][startY];
        }
        int[] numbers = new int[9];
        int k = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                numbers[k] = getNumbers(startX + i * size, startY + j * size, size);
                k++;
            }
        }
        int sameNumber = isAllSame(numbers);
        if (sameNumber != -2) {
            return sameNumber;
        } else {
            addTargetNumber(numbers);
            return -2;
        }
    }

    private static int isAllSame(int[] numbers) {
        int number = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] != number) {
                return -2;
            }
        }
        return number;
    }

    private static void addTargetNumber(int[] numbers) {
        for (int i = 0; i < 9; i++) {
            if (numbers[i] == -1) {
                a++;
            }
            if (numbers[i] == 0) {
                b++;
            }
            if (numbers[i] == 1) {
                c++;
            }
        }
    }
}
