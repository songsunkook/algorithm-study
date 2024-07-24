/*
    BAEKJOON 18808번 스티커 붙이기
    https://www.acmicpc.net/problem/18808

    추가 학습 내용
    - 2차원 배열의 90도 회전 시 배열 인덱스 계산

    복습 필요: O
    풀이 참고: 조금
*/

import java.io.*;
import java.util.*;

public class Main {

    static int N, M, K;
    static List<Sticker> sti = new ArrayList<>();
    static int[][] notebook;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        notebook = new int[N][M];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int[][] board = new int[R][C];
            for (int r = 0; r < R; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < C; c++) {
                    board[r][c] = Integer.parseInt(st.nextToken());
                }
            }
            sti.add(new Sticker(board));
        }
        System.out.print(func(0));
    }

    static int func(int idx) {
        if (idx == K) {
            return count();
        }
        int[][] board = sti.get(idx).board;
        for (int i = 0; i < 4; i++) {
            for (int r = 0; r <= N - board.length; r++) {
                for (int c = 0; c <= M - board[0].length; c++) {
                    if (canPlace(r, c, board)) {
                        place(r, c, board, 1);
                        int ans = func(idx + 1);
                        if (ans != -1) {
                            return ans;
                        }
                        place(r, c, board, 0);
                    }
                }
            }
            board = rotate(board);
        }
        return func(idx + 1);
    }

    static boolean canPlace(int r, int c, int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 1 && notebook[i + r][j + c] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    static void place(int r, int c, int[][] board, int value) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 1) {
                    notebook[i + r][j + c] = value;
                }
            }
        }
    }

    static int count() {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (notebook[i][j] == 1) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    static int[][] rotate(int[][] board) {
        int R = board.length;
        int C = board[0].length;
        int[][] ans = new int[C][R];
        for (int r = 0; r < C; r++) {
            for (int c = 0; c < R; c++) {
                ans[r][c] = board[R - 1 - c][r];
            }
        }
        return ans;
    }

    static class Sticker {
        int[][] board;

        Sticker(int[][] board) {
            this.board = board;
        }
    }
}
