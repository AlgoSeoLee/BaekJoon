package study.moon.d201105.t10;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int answer = 0;
            int count = 1;
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                if(s.charAt(j)=='O') {
                    answer+=count;
                    count++;
                } else {
                    count = 1;
                }
            }
            bw.write(answer+"\n");
        }
        bw.flush();
        bw.close();
    }
}
