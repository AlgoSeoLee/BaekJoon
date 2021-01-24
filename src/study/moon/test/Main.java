package study.moon.test;

public class Main {

    public static void main(String[] args) {
        Bar bar = new Bar();
    }
}
class Foo {
    public Foo() {
        doSomething();
    }
    public void doSomething() {
        System.out.println("do something acceptable");
    }
}
class Bar extends Foo {
    @Override
    public void doSomething() {
        System.out.println("yolo");
    }
}
