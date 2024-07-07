/*
    BAEKJOON 2468번 안전 영역
    https://www.acmicpc.net/problem/2468

    추가 학습 내용
    - 

    복습 필요: x
    풀이 참고: x
*/

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int max = 0;
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(board[i][j], max);
            }
        }
        int maxCount = 0;
        for (int i = 0; i < max; i++) {
            maxCount = Math.max(maxCount, getCount(i));
        }
        System.out.print(maxCount);
    }

    public static int getCount(int water) {
        int count = 0;
        boolean[][] vis = new boolean[N][N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (board[r][c] > water && !vis[r][c]) {
                    bfs(vis, r, c, water);
                    count++;
                }
            }
        }
        return count;
    }

    public static void bfs(boolean[][] vis, int r, int c, int water) {
        Queue<Pos> q = new LinkedList<>();
        q.offer(new Pos(r, c));
        vis[r][c] = true;
        while (!q.isEmpty()) {
            Pos cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
                    continue;
                }
                if (vis[nr][nc] || board[nr][nc] <= water) {
                    continue;
                }
                q.offer(new Pos(nr, nc));
                vis[nr][nc] = true;
            }
        }
    }

    public static class Pos {
        int r, c;

        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
