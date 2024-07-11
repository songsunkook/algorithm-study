/*
    BAEKJOON 2630번 색종이 만들기
    https://www.acmicpc.net/problem/2630

    추가 학습 내용
    - 

    복습 필요: -
    풀이 참고: x
*/

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] count;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        count = new int[2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solve(N, 0, 0);
        System.out.println(count[0]);
        System.out.println(count[1]);
    }

    static void solve(int n, int r, int c) {
        if (n == 1) {
            count[board[r][c]]++;
            return;
        }
        if (isOneColor(n, r, c)) {
            count[board[r][c]]++;
            return;
        }
        for (int i = 0; i < 4; i++) {
            solve(n / 2, r + (n / 2) * (i / 2), c + (n / 2) * (i % 2));
        }
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
