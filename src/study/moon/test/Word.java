package study.moon.test;

import java.util.List;

public enum Word {
    HELLO("HELLO"),
    WORLD("WORLD");

    Word(String words) {
    }

    public static List<Word> getAll(){
        return List.of(HELLO,WORLD);
    }
}
