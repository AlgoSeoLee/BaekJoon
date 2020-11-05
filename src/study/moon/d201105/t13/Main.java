package study.moon.d201105.t13;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            bw.write(s.charAt(i));
            count++;
            if(count >= 10) {
                bw.write("\n");
                count = 0;
            }
        }
        bw.flush();
        bw.close();
    }
}
