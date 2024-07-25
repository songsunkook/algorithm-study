/*
    BAEKJOON 12100번 2048 (Easy)
    https://www.acmicpc.net/problem/12100

    추가 학습 내용
    - 

    복습 필요: O
    풀이 참고: O
*/

import java.io.*;
import java.util.*;

public class Main {

    static int N, max;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        func(0);
        System.out.print(max);
    }

    static void func(int step) {
        if (step == 5) {
            getMax();
            return;
        }
        int[][] original = new int[N][N];
        for (int i = 0; i < N; i++) {
            original[i] = Arrays.copyOf(board[i], N);
        }
        // direction
        for (int i = 0; i < 4; i++) {
            move();
            func(step + 1);
            for (int idx = 0; idx < N; idx++) {
                board[idx] = Arrays.copyOf(original[idx], N);
            }
            for (int j = 0; j <= i; j++) {
                rotate();
            }
        }
    }

    static void move() {
        for (int r = 0; r < N; r++) {
            int idx = 0;
            int[] temp = new int[N];
            for (int c = 0; c < N; c++) {
                if (board[r][c] != 0) {
                    if (temp[idx] == 0) {
                        temp[idx] = board[r][c];
                    } else if (board[r][c] == temp[idx]) {
                        temp[idx++] *= 2;
                    } else {
                        temp[++idx] = board[r][c];
                    }
                }
            }
            board[r] = temp;
        }
    }

    static void rotate() {
        int[][] temp = new int[N][N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                temp[r][c] = board[N - 1 - c][r];
            }
        }
        board = temp;
    }

    static void getMax() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                max = Math.max(max, board[i][j]);
            }
        }
    }
}
