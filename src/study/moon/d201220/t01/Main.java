package study.moon.d201220.t01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        //given
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int answer = 0;
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);

        split = br.readLine().split(" ");
        int truthCount = Integer.parseInt(split[0]);

        Set<Integer> truthMen = new HashSet<>();
        for (int i = 0; i < truthCount; i++) {
            truthMen.add(Integer.parseInt(split[i + 1]));
        }

        List<Integer>[] parties = new ArrayList[m];
        boolean[] visit = new boolean[parties.length];
        for (int i = 0; i < m; i++) {
            parties[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            split = br.readLine().split(" ");
            int participantsNum = Integer.parseInt(split[0]);
            for (int j = 0; j < participantsNum; j++) {
                parties[i].add(Integer.parseInt(split[j + 1]));
            }
        }

        //when
        int count = 0;
        int check = -1;
        while (count != check) {
            check++;
            for (int i = 0; i < parties.length; i++) {
                if (!visit[i]) {
                    if (hasTruthMen(parties[i], truthMen)) {
                        visit[i] = true;
                        truthMen.addAll(parties[i]);
                        count++;
                        break;
                    }
                }
            }
        }

        //then
        bw.write(parties.length - count + "");
        bw.flush();
        bw.close();
    }

    private static boolean hasTruthMen(List<Integer> participants, Set<Integer> truthMen) {
        for (Integer truthMAN : truthMen) {
            if (participants.contains(truthMAN)) {
                return true;
            }
        }
        return false;
    }

}
