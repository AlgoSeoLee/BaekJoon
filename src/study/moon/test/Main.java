package study.moon.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputNumber = Integer.parseInt(br.readLine());

        String string = switch (inputNumber) {
            case 1 -> {
                System.out.println("1입니다.");
                yield "1";
            }
            case 2 -> "2입니다.";
            case 3 -> "3입니다.";
            case 4 -> "4입니다.";
            default -> "1,2,3,4 가 아닙니다.";
        };

    }
}

