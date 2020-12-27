package study.moon.y2020.m12.d201208.t03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            String[] split = br.readLine().split(" ");
            if(split[0].equals("0") && split[1].equals("0") && split[2].equals("0")) {
                break;
            }
            long[] length = new long[3];
            for (int i = 0; i < 3; i++) {
                length[i] = Integer.parseInt(split[i]);
            }
            Arrays.sort(length);

            if(length[2]*length[2] == length[1]*length[1] + length[0]*length[0]) {
                bw.write("right\n");
            }else {
                bw.write("wrong\n");
            }
        }
        bw.flush();
        bw.close();
    }

}
