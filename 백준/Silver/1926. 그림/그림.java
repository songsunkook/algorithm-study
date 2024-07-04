/*
    BAEKJOON 1926번 그림
    https://www.acmicpc.net/problem/1926

    추가 학습 내용
    - 

    복습 필요: x
    풀이 참고: x
*/

import java.io.*;
import java.util.*;

public class Main {

    public static int n, m;
    public static int[][] board;
    public static boolean[][] vis;
    public static int[] cr = {-1, 0, 1, 0};
    public static int[] cc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        vis = new boolean[n][m];
        for (int r = 0; r < n; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < m; c++) {
                board[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0, count = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (board[r][c] == 1 && !vis[r][c]) {
                    count++;
                    max = Math.max(bfs(r, c), max);
                }
            }
        }
        bw.write(count + "\n" + max);
        bw.close();
        br.close();
    }

    public static int bfs(int r, int c) {
        vis[r][c] = true;
        Queue<Pos> q = new LinkedList<>();
        q.offer(new Pos(r, c));
        int ret = 1;
        while (!q.isEmpty()) {
            Pos cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nr = cur.r + cr[i];
                int nc = cur.c + cc[i];
                if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                    continue;
                }
                if (board[nr][nc] == 0 || vis[nr][nc]) {
                    continue;
                }
                vis[nr][nc] = true;
                q.offer(new Pos(nr, nc));
                ret++;
            }
        }
        return ret;
    }

    public static class Pos {
        int r, c;

        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
