package study.moon.y2020.m12.d201210.t01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
//https://www.acmicpc.net/problem/1620`
public class Main {

    static Map<Integer,String> pokemon;
    static Map<String,Integer> index;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);

        pokemon = new HashMap<>();
        index = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            String s = br.readLine();
            pokemon.put(i,s);
            index.put(s,i);
        }

        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            boolean word = s.matches("^[a-zA-Z]*$");
            boolean index = s.matches("^[0-9]*$");
            if (word) {
                bw.write(findIndex(s)+"\n");
            }
            if (index) {
                bw.write(findPokemon(s)+"\n");
            }
        }
        bw.flush();
        bw.close();
    }

    private static String findPokemon(String index) {
        int number = Integer.parseInt(index);
        return pokemon.get(number);
    }

    private static String findIndex(String word) {
        return Integer.toString(index.get(word));
    }
}


//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
//
//public class Main {
//
//    static String[] pokemon;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        String[] split = br.readLine().split(" ");
//        int n = Integer.parseInt(split[0]);
//        int m = Integer.parseInt(split[1]);
//
//        pokemon = new String[n + 1];
//        for (int i = 1; i <= n; i++) {
//            pokemon[i] = br.readLine();
//        }
//
//        for (int i = 0; i < m; i++) {
//            String s = br.readLine();
//            boolean word = s.matches("^[a-zA-Z]*$");
//            boolean index = s.matches("^[0-9]*$");
//            if (word) {
//                bw.write(findIndex(s)+"\n");
//            }
//            if (index) {
//                bw.write(findPokemon(s)+"\n");
//            }
//        }
//        bw.flush();
//        bw.close();
//    }
//
//    private static String findPokemon(String index) {
//        int number = Integer.parseInt(index);
//        return pokemon[number];
//    }
//
//    private static String findIndex(String word) {
//        int index = 0;
//        for (int i = 1; i < pokemon.length; i++) {
//            if (pokemon[i].equals(word)) {
//                index = i;
//                break;
//            }
//        }
//        return String.valueOf(index);
//    }
//}
