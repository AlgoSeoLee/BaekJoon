package study.moon.y2020.m12.d201229.t01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        String bomb = br.readLine();
        BombStack bombStack = new BombStack(bomb);
        for (int i = 0; i < s.length(); i++) {
            bombStack.add(s.charAt(i));
        }
        if (bombStack.builder.length()==0) {
            bw.write("FRULA");
        } else {
            bw.write(bombStack.builder.toString());
        }
        bw.flush();
        bw.close();
    }

}

class BombStack {
    StringBuilder builder;
    String bomb;


    public BombStack(String bomb) {
        this.builder = new StringBuilder();
        this.bomb = bomb;
    }

    public void add(char c) {
        builder.append(c);
        if (builder.length()>=bomb.length()) {
            bombChaining();
        }
    }

    public void bombChaining() {
        while (builder.length()>=bomb.length()) {
            if (builder.substring(builder.length()-bomb.length(),builder.length()).equals(bomb)) {
                builder.delete(builder.length()-bomb.length(),builder.length());
            }else {
                break;
            }
        }
    }
}
