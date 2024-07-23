/*
    BAEKJOON 15683번 감시
    https://www.acmicpc.net/problem/15683

    추가 학습 내용
    - 

    복습 필요: o
    풀이 참고: x
*/

import java.io.*;
import java.util.*;

public class Main {

    static int R, C, min;
    static int[][] board;
    static List<CCTV> cctv;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        min = Integer.MAX_VALUE;
        cctv = new ArrayList<>();
        board = new int[R][C];
        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < C; c++) {
                board[r][c] = Integer.parseInt(st.nextToken());
                if (board[r][c] > 0 && board[r][c] < 6) {
                    cctv.add(new CCTV(r, c, board[r][c], 0));
                }
            }
        }
        solve(0);
        System.out.print(min);
    }

    static void solve(int idx) {
        if (idx == cctv.size()) {
            min = Math.min(min, getCnt());
            return;
        }
        for (int d = 0; d < 4; d++) {
            cctv.get(idx).dir = d;
            solve(idx + 1);
        }
    }

    static int getCnt() {
        int[][] boardCp = new int[R][C];
        for (int i = 0; i < R; i++) {
            boardCp[i] = Arrays.copyOf(board[i], C);
        }
        for (CCTV c : cctv) {
            switch (c.type) {
                case 1:
                    if (c.dir == 0)
                        fillDir(boardCp, c.r, c.c, new int[] {}, new int[] {1});
                    if (c.dir == 1)
                        fillDir(boardCp, c.r, c.c, new int[] {1}, new int[] {});
                    if (c.dir == 2)
                        fillDir(boardCp, c.r, c.c, new int[] {}, new int[] {-1});
                    if (c.dir == 3)
                        fillDir(boardCp, c.r, c.c, new int[] {-1}, new int[] {});
                    break;
                case 2:
                    if (c.dir == 0 || c.dir == 2)
                        fillDir(boardCp, c.r, c.c, new int[] {}, new int[] {-1, 1});
                    if (c.dir == 1 || c.dir == 3)
                        fillDir(boardCp, c.r, c.c, new int[] {-1, 1}, new int[] {});
                    break;
                case 3:
                    if (c.dir == 0)
                        fillDir(boardCp, c.r, c.c, new int[] {-1}, new int[] {1});
                    if (c.dir == 1)
                        fillDir(boardCp, c.r, c.c, new int[] {1}, new int[] {1});
                    if (c.dir == 2)
                        fillDir(boardCp, c.r, c.c, new int[] {1}, new int[] {-1});
                    if (c.dir == 3)
                        fillDir(boardCp, c.r, c.c, new int[] {-1}, new int[] {-1});
                    break;
                case 4:
                    if (c.dir == 0)
                        fillDir(boardCp, c.r, c.c, new int[] {-1}, new int[] {-1, 1});
                    if (c.dir == 1)
                        fillDir(boardCp, c.r, c.c, new int[] {-1, 1}, new int[] {1});
                    if (c.dir == 2)
                        fillDir(boardCp, c.r, c.c, new int[] {1}, new int[] {-1, 1});
                    if (c.dir == 3)
                        fillDir(boardCp, c.r, c.c, new int[] {-1, 1}, new int[] {-1});
                    break;
                case 5:
                    fillDir(boardCp, c.r, c.c, new int[] {-1, 1}, new int[] {-1, 1});
                    break;
            }
        }
        int ans = 0;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (boardCp[r][c] == 0) {
                    ans++;
                }
            }
        }
        return ans;
    }

    static void fillDir(int[][] boardCp, int r, int c, int[] dr, int[] dc) {
        for (int tr : dr) {
            int nr = r + tr;
            while (nr >= 0 && nr < R && boardCp[nr][c] != 6) {
                boardCp[nr][c] = 10;
                nr += tr;
            }
        }
        for (int tc : dc) {
            int nc = c + tc;
            while (nc >= 0 && nc < C && boardCp[r][nc] != 6) {
                boardCp[r][nc] = 10;
                nc += tc;
            }
        }
    }

    static class CCTV {
        int r, c, type, dir;

        CCTV(int r, int c, int type, int dir) {
            this.r = r;
            this.c = c;
            this.type = type;
            this.dir = dir;
        }
    }
}
