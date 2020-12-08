package study.moon.d201208.t08;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    static int n = 0;
    static int m = 0;
    static int b = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] split = br.readLine().split(" ");
        n = Integer.parseInt(split[0]);
        m = Integer.parseInt(split[1]);
        b = Integer.parseInt(split[2]);

        int[][] arr = new int[n][m];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            String[] split1 = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(split1[j]);
                if (arr[i][j] > max) {
                    max = arr[i][j];
                }
                if (arr[i][j] < min) {
                    min = arr[i][j];
                }
            }
        }

        List<Data> list = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            int needTimes = getNeedTimes(i, arr);
            if(needTimes != -1) {
                list.add(new Data(needTimes,i));
            }
        }
        list = list.stream().sorted().collect(Collectors.toList());
        bw.write(list.get(0).time+" "+list.get(0).layer);
        bw.flush();
        bw.close();

    }

    public static int getNeedTimes(int layer, int[][] arr) {
        int result = 0;
        int blocks = b;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] > layer) {
                    result += 2 * (arr[i][j] - layer);
                    blocks += (arr[i][j] - layer);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] < layer) {
                    result += (layer - arr[i][j]);
                    blocks -= (layer - arr[i][j]);
                }
            }
        }
        if(blocks < 0) {
            return -1;
        }
        return result;
    }
}

class Data implements Comparable<Data>{
    int time;
    int layer;

    public Data(int time, int layer) {
        this.time = time;
        this.layer = layer;
    }

    @Override
    public int compareTo(Data o) {
        if (this.time > o.time) {
            return 1;
        } else if (time == o.time) {
            if (layer < o.layer) {
                return 1;
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    }
}
