/*
    BAEKJOON 2447번 별 찍기 - 10
    https://www.acmicpc.net/problem/2447

    추가 학습 내용
    - 

    복습 필요: x
    풀이 참고: 조금
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
        board = new char[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(board[i], ' ');
        }
        func(N, 0, 0);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bw.write(board[i][j]);
            }
            bw.write("\n");
        }
        bw.close();
    }

    static void func(int n, int r, int c) {
        if (n == 1) {
            board[r][c] = '*';
            return;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    continue;
                }
                func(n / 3, r + i * n / 3, c + j * n / 3);
            }
        }
    }
}
