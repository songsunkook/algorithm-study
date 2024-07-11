/*
    BAEKJOON 1780번 종이의 개수
    https://www.acmicpc.net/problem/1780

    추가 학습 내용
    - 제곱 함수: Math.pow()

    복습 필요: o
    풀이 참고: 조금
*/

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] result;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        result = new int[3];
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        func(N, 0, 0);
        System.out.println(result[0]);
        System.out.println(result[1]);
        System.out.println(result[2]);
    }

    static void func(int n, int r, int c) {
        if (n == 1) {
            result[board[r][c] + 1]++;
            return;
        }
        if (isOneColor(n, r, c)) {
            result[board[r][c] + 1]++;
            return;
        }
        for (int i = 0; i < 9; i++) {
            func(n / 3, r + i / 3 * (n / 3), c + i % 3 * (n / 3));
        }
    }

    static boolean isOneColor(int size, int r, int c) {
        int a = board[r][c];
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (board[i][j] != a) {
                    return false;
                }
            }
        }
        return true;
    }
}
