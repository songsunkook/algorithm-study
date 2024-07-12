/*
    BAEKJOON 2447번 별 찍기 - 10
    https://www.acmicpc.net/problem/2447

    추가 학습 내용
    -

    복습 필요: x
    풀이 참고: x
*/

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        board = new char[N][N * 2];
        for (int i = 0; i < N; i++) {
            Arrays.fill(board[i], ' ');
        }
        func(N, 0, 0);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N * 2; j++) {
                bw.write(board[i][j]);
            }
            bw.write("\n");
        }
        bw.close();
    }

    static void func(int n, int r, int c) {
        if (n == 3) {
            fill(r, c);
            return;
        }
        func(n / 2, r, c + n / 2);
        func(n / 2, r + n / 2, c);
        func(n / 2, r + n / 2, c + n);
    }

    static void fill(int r, int c) {
        board[r][c + 2] = '*';
        board[r + 1][c + 1] = '*';
        board[r+1][c+3] = '*';
        for (int i = 0; i < 5; i++) {
            board[r + 2][c + i] = '*';
        }
    }
}
