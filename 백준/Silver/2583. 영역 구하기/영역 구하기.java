/*
    BAEKJOON 2583번 영역 구하기
    https://www.acmicpc.net/problem/2583

    추가 학습 내용
    - 

    복습 필요: -
    풀이 참고: x
*/

import java.io.*;
import java.util.*;

public class Main {

    static int R, C, K;
    static int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
    static boolean[][] board, vis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        board = new boolean[R][C];
        vis = new boolean[R][C];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int sc = Integer.parseInt(st.nextToken());
            int sr = Integer.parseInt(st.nextToken());
            int ec = Integer.parseInt(st.nextToken()) - 1;
            int er = Integer.parseInt(st.nextToken()) - 1;
            fillBox(new Pos(sr, sc), new Pos(er, ec));
        }

        PriorityQueue<Integer> area = new PriorityQueue<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!vis[i][j] && !board[i][j]) {
                    area.add(getArea(i, j));
                }
            }
        }
        bw.write(area.size() + "\n");
        while (!area.isEmpty()) {
            bw.write(area.poll() + " ");
        }
        bw.close();
        br.close();
    }

    public static int getArea(int r, int c) {
        int area = 1;
        Queue<Pos> q = new LinkedList<>();
        q.offer(new Pos(r, c));
        vis[r][c] = true;
        while (!q.isEmpty()) {
            Pos cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                if (nr < 0 || nc < 0 || nr >= R || nc >= C) {
                    continue;
                }
                if (board[nr][nc] || vis[nr][nc]) {
                    continue;
                }
                q.offer(new Pos(nr, nc));
                vis[nr][nc] = true;
                area++;
            }
        }
        return area;
    }

    public static void fillBox(Pos start, Pos end) {
        for (int r = start.r; r <= end.r; r++) {
            for (int c = start.c; c <= end.c; c++) {
                board[r][c] = true;
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
