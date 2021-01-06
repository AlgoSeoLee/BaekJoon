package study.moon.y2021.m01.d06.t01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class Main {

    //0 : 빈 공간, 1 : 사과, 2 : 뱀
    static int[][] board;

    static int N;

    //0: 오른쪽,1:아래,2:왼쪽,3:위
    static int direction = 0;

    static String[] timeBoard;

    static int time = 0;

    static LinkedList<Place> snake = new LinkedList<>();

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //보드 생성
        N = Integer.parseInt(br.readLine());
        board = new int[N + 1][N + 1];

        //사과 입력
        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            String[] s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            board[x][y] = 1;
        }

        //방향변환
        int L = Integer.parseInt(br.readLine());
        timeBoard = new String[10001];
        for (int i = 0; i < L; i++) {
            String[] s = br.readLine().split(" ");
            timeBoard[Integer.parseInt(s[0])] = s[1];
        }

        //초기화
        snake.add(new Place(1, 1));
        board[1][1] = 2;

        //로직 시작
        while (true) {
            snakeMove();
        }

    }

    private static void snakeMove() throws IOException {
        time++;
        moveToDirection();
    }

    private static void moveToDirection() throws IOException {
        moveFirst();
        check();
        changeDirection();
    }

    private static void changeDirection() {
        if (timeBoard[time] == null) {
            return;
        }
        if (timeBoard[time].equals("L")) {
            changeLeft();
            return;
        }
        if (timeBoard[time].equals("D")) {
            changeRight();
            return;
        }
    }

    private static void changeLeft() {
        if (direction == 0) {
            direction = 3;
        } else {
            direction--;
        }
    }

    private static void changeRight() {
        direction++;
        direction %= 4;
    }

    private static void check() throws IOException {
        Place peek = snake.peek();
        if (peek.x <= 0 || peek.x > N || peek.y <= 0 || peek.y > N) {
            bw.write(time + "");
            bw.flush();
            System.exit(0);
        }
        if (board[peek.x][peek.y] == 2) {
            bw.write(time + "");
            bw.flush();
            System.exit(0);
        }
        if (board[peek.x][peek.y] == 1) {
            board[peek.x][peek.y] = 2;
        } else {
            board[peek.x][peek.y] = 2;
            Place place = snake.removeLast();
            board[place.x][place.y] = 0;
        }
    }

    private static void moveFirst() {
        Place peek = snake.peek();
        if (direction == 0) {
            snake.addFirst(new Place(peek.x, peek.y+1));
        }
        if (direction == 1) {
            snake.addFirst(new Place(peek.x+1, peek.y));
        }
        if (direction == 2) {
            snake.addFirst(new Place(peek.x, peek.y-1));
        }
        if (direction == 3) {
            snake.addFirst(new Place(peek.x-1, peek.y));
        }
    }
}

class Place {

    int x;
    int y;

    public Place(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
