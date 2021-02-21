package study.moon.test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        try (var stream = new BufferedInputStream(new FileInputStream("test.txt"))){

        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

