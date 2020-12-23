package study.moon.d201222.t02_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

//메모리초과
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] split = br.readLine().split(" ");
        long a = Long.parseLong(split[0]);
        long b = Long.parseLong(split[1]);
        long c = Long.parseLong(split[2]);
        long result = a;
        List<Long> routine = new ArrayList<>();
        routine.add(result % c);
        result *= a;
        routine.add(result % c);
        result *= a;
        while (true) {
            long mod = result % c;
            routine.add(mod);
            if (mod == routine.get(1)) {
                routine.remove(routine.size()-1);
                break;
            }
            result *= a;
        }
        int index = (int) b % (routine.size()-1) - 1;
        if (index == -1) {
            index = routine.size() - 1;
        }
        bw.write(routine.get(index)+"");
        bw.flush();
        bw.close();
    }

}
