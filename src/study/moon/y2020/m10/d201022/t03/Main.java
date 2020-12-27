package study.moon.y2020.m10.d201022.t03;

import java.util.*;

class Main {
    static Queue<Place> queue;
    static int size;
    static List<Integer> answer;
    static int[] X = {-1,1,0,0};
    static int[] Y = {0,0,-1,1};
    private static void solution(int sizeOfMatrix, int[][] matrix) {
        size = 0;
        queue = new LinkedList<>();
        answer = new ArrayList<>();

        queue.add(new Place(0,0));
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                queue.offer(new Place(i,j));
                bfs(matrix);
                answer.add(size);
                size = 0;
            }
        }

        int[] array = answer.stream().filter(v -> v != 0).sorted().mapToInt(v -> v).toArray();
        if(array.length == 0) {
            System.out.println(0);
            return;
        }
        System.out.println(array.length);
        for (int j : array) {
            System.out.print(j + " ");
        }
    }

    public static void bfs(int[][] matrix) {
        while(!queue.isEmpty()) {
            Place poll = queue.poll();
            if(poll.x < 0 || poll.x >= matrix.length || poll.y < 0 || poll.y >= matrix.length) {
                continue;
            }
            if(matrix[poll.x][poll.y] == 0 || matrix[poll.x][poll.y] == 2) {
                continue;
            }
            size++;
            matrix[poll.x][poll.y] = 2;
            for (int i = 0; i < 4; i++) {
                queue.offer(new Place(poll.x+X[i],poll.y+Y[i]));
            }
        }
    }

    private static class InputData {
        int sizeOfMatrix;
        int[][] matrix;
    }

    private static InputData processStdin() {
        InputData inputData = new InputData();

        try (Scanner scanner = new Scanner(System.in)) {
            inputData.sizeOfMatrix = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

            inputData.matrix = new int[inputData.sizeOfMatrix][inputData.sizeOfMatrix];
            for (int i = 0; i < inputData.sizeOfMatrix; i++) {
                String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
                for (int j = 0; j < inputData.sizeOfMatrix; j++) {
                    inputData.matrix[i][j] = Integer.parseInt(buf[j]);
                }
            }
        } catch (Exception e) {
            throw e;
        }

        return inputData;
    }

    public static void main(String[] args) throws Exception {
        InputData inputData = processStdin();

        solution(inputData.sizeOfMatrix, inputData.matrix);
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

