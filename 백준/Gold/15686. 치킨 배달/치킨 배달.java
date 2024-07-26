/*
    BAEKJOON 15686번 치킨 배달
    https://www.acmicpc.net/problem/15686

    추가 학습 내용
    - 자바 절대값 함수

    복습 필요: O 
    풀이 참고: o
*/

import java.io.*;
import java.util.*;

public class Main {

    static int N, M, min;
    static int[][] board;
    static List<Pos> shop, home;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        min = Integer.MAX_VALUE;
        board = new int[N][N];
        home = new ArrayList<>();
        shop = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int n = Integer.parseInt(st.nextToken());
                if (n == 1) {
                    home.add(new Pos(i, j));
                }
                if (n == 2) {
                    shop.add(new Pos(i, j));
                }
                board[i][j] = n;
            }
        }
        func(0, 0, new boolean[shop.size()]);
        System.out.print(min);
    }

    static void func(int idx, int cnt, boolean[] selected) {
        if (cnt == M) {
            getDistance(selected);
            return;
        }
        if (idx >= shop.size()) {
            return;
        }
        selected[idx] = true;
        func(idx + 1, cnt + 1, selected);
        selected[idx] = false;
        func(idx + 1, cnt, selected);
    }

    static void getDistance(boolean[] selected) {
        int sum = 0;
        for (Pos h : home) {
            int temp = Integer.MAX_VALUE;
            for (int i = 0; i < shop.size(); i++) {
                if (selected[i]) {
                    int dist = Math.abs(shop.get(i).r - h.r) + Math.abs(shop.get(i).c - h.c);
                    temp = Math.min(dist, temp);
                }
            }
            sum += temp;
        }
        min = Math.min(min, sum);
    }

    static class Pos {
        int r, c;

        Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
