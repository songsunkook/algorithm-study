/*
    BAEKJOON 4179번 불!
    https://www.acmicpc.net/problem/4179

    추가 학습 내용
    - 

    복습 필요: O
    풀이 참고: O
*/

import java.io.*;
import java.util.*;

public class Main {

    public static int[] cr = {-1, 0, 1, 0};
    public static int[] cc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[][] board = new char[R][C];
        int[][] fireDist = new int[R][C];
        int[][] hunDist = new int[R][C];
        Queue<Pos> fireQueue = new LinkedList<>();
        Queue<Pos> hunQueue = new LinkedList<>();
        for (int i = 0; i < R; i++) {
            Arrays.fill(fireDist[i], -1);
            Arrays.fill(hunDist[i], -1);
        }
        for (int r = 0; r < R; r++) {
            char[] line = br.readLine().toCharArray();
            for (int c = 0; c < C; c++) {
                board[r][c] = line[c];
                if (board[r][c] == 'J') {
                    hunDist[r][c] = 0;
                    hunQueue.offer(new Pos(r, c));
                }
                if (board[r][c] == 'F') {
                    fireQueue.offer(new Pos(r, c));
                    fireDist[r][c] = 0;
                }
            }
        }

        while (!fireQueue.isEmpty()) {
            Pos cur = fireQueue.poll();
            for (int i = 0; i < 4; i++) {
                int nr = cur.r + cr[i];
                int nc = cur.c + cc[i];
                if (nr < 0 || nc < 0 || nr >= R || nc >= C) {
                    continue;
                }
                if (board[nr][nc] == '#' || fireDist[nr][nc] != -1) {
                    continue;
                }
                fireQueue.offer(new Pos(nr, nc));
                fireDist[nr][nc] = fireDist[cur.r][cur.c] + 1;
            }
        }

        Pos jh = hunQueue.peek();
        if (jh.r == R - 1 || jh.r == 0 || jh.c == C - 1 || jh.c == 0) {
            System.out.print(1);
            return;
        }
        while (!hunQueue.isEmpty()) {
            Pos cur = hunQueue.poll();
            for (int i = 0; i < 4; i++) {
                int nr = cur.r + cr[i];
                int nc = cur.c + cc[i];
                if (nr < 0 || nc < 0 || nr >= R || nc >= C) {
                    continue;
                }
                if (board[nr][nc] == '#' || hunDist[nr][nc] != -1 || (fireDist[nr][nc] != -1 && hunDist[cur.r][cur.c] + 1 >= fireDist[nr][nc])) {
                    continue;
                }
                if (nr == R - 1 || nr == 0 || nc == C - 1 || nc == 0) {
                    System.out.print(hunDist[cur.r][cur.c] + 2);
                    return;
                }
                hunQueue.offer(new Pos(nr, nc));
                hunDist[nr][nc] = hunDist[cur.r][cur.c] + 1;
            }
        }
        System.out.print("IMPOSSIBLE");
    }

    public static class Pos {
        int r, c;

        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
