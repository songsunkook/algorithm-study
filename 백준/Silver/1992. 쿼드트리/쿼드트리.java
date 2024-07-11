/*
    BAEKJOON 1992번 쿼드트리
    https://www.acmicpc.net/problem/1992

    추가 학습 내용
    - 

    복습 필요: x
    풀이 참고: x
*/

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static BufferedReader br;
    static BufferedWriter bw;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            int count = 0;
            for (char c : br.readLine().toCharArray()) {
                board[i][count] = Integer.parseInt(String.valueOf(c));
                count++;
            }
        }
        solve(N, 0, 0);
        bw.close();
    }

    static void solve(int n, int r, int c) throws IOException {
        if (n == 1 || isOneColor(n, r, c)) {
            bw.write(String.valueOf(board[r][c]));
            return;
        }
        bw.write("(");
        for (int i = 0; i < 4; i++) {
            solve(n / 2, r + (i / 2 * n / 2), c + (i % 2 * n / 2));
        }
        bw.write(")");
    }

    static boolean isOneColor(int n, int r, int c) {
        int a = board[r][c];
        for (int i = r; i < r + n; i++) {
            for (int j = c; j < c + n; j++) {
                if (board[i][j] != a) {
                    return false;
                }
            }
        }
        return true;
    }
}
