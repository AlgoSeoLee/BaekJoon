package study.moon.d201123.t04;

import java.io.*;
// https://www.acmicpc.net/problem/10830

public class Main {
    static int N;
    static long B;
    static int[][] matrix1;

    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str=br.readLine().split(" ");
        N=Integer.parseInt(str[0]);
        B=Long.parseLong(str[1]);
        matrix1=new int[N][N];
        for(int i = 0 ; i < N ; i++) {
            String[] s =br.readLine().split(" ");
            for(int j = 0 ; j < N ; j++) {
                matrix1[i][j]=Integer.parseInt(s[j]);
            }
        }
        int[][] matrixFinal = matrixResult(B);
        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < N ; j++) {
                bw.write(matrixFinal[i][j] % 1000 + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    static int[][] matrixResult(long num){
        int[][] temp;
        int[][] result=new int[N][N];
        if(num==1) return matrix1;
        if(num%2==0) {
            temp=matrixResult(num/2);
            calculateMatrix(temp, result, temp);
        }
        else {
            temp=matrixResult(num-1);
            calculateMatrix(temp, result, matrix1);
        }
        return result;
    }

    private static void calculateMatrix(int[][] temp, int[][] result, int[][] matrix1) {
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                for(int l=0;l<N;l++) {
                    result[i][j]+=temp[i][l]* matrix1[l][j];
                }
                result[i][j]%=1000;
            }
        }
    }
}
