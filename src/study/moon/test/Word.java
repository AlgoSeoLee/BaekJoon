package study.moon.test;

public enum Word {
    OH,
    HELLO("HELLO"),
    WORLD("WORLD"),

    MY_NAME("MY_NAME",1),
    IS_MOON("IS_MOON",2);

    String word;
    int number;

    Word() {
    }

    Word(String word) {
        this.word = word;
    }

    Word(String word, int number) {
        this.word = word;
        this.number = number;
    }

}
