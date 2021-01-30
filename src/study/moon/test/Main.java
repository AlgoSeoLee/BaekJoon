package study.moon.test;

import java.util.Arrays;
import java.util.EnumSet;
import java.lang.Enum;

public class Main {

    public static void main(String[] args) {
        Word[] words = new Word[4];
        words[0] = Word.MY_NAME;
        words[1] = Word.HELLO;
        words[2] = Word.IS_MOON;
        words[3] = Word.WORLD;
        Arrays.sort(words);
        System.out.println(Arrays.toString(words));
        EnumSet<Word> enumSet1 = EnumSet.allOf(Word.class);
        EnumSet<Word> enumSet2 = EnumSet.of(words[0],words[1]);
        Word.values();

        System.out.println(enumSet1);
        System.out.println(enumSet2);
    }
}
