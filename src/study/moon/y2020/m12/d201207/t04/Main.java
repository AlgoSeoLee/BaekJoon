package study.moon.y2020.m12.d201207.t04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

//https://www.acmicpc.net/problem/10814
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int inputNumber = Integer.parseInt(br.readLine());

        Data[] data = new Data[inputNumber];

        for (int i = 0; i < inputNumber; i++) {
            String[] split = br.readLine().split(" ");
            data[i] = new Data(Integer.parseInt(split[0]), split[1]);
        }

        Arrays.sort(data);

        for (int i = 0; i < inputNumber; i++) {
            bw.write(data[i].age+" "+data[i].name+"\n");
        }

        bw.flush();
        bw.close();
    }
}

class Data implements Comparable<Data> {
    int age;
    String name;

    public Data(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(Data o) {
        return age-o.age;
    }
}

