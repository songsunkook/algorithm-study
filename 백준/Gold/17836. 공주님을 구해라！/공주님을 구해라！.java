import java.io.*;
import java.util.*;

class Main {
    static int R, C, T;
    static int[][] arr;
    static int[][][] vis;
    static int[][] dd = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        arr = new int[R][C];
        vis = new int[2][R][C];
        for (int i = 0; i < 2; i++)
            for (int r = 0; r < R; r++)
                Arrays.fill(vis[i][r], Integer.MAX_VALUE);
        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < C; c++)
                arr[r][c] = Integer.parseInt(st.nextToken());
        }

        Queue<N> q = new LinkedList<>();
        q.offer(new N(0, 0, 0));
        vis[0][0][0] = 0;
        int result = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            N cur = q.poll();
            if (cur.r == R - 1 && cur.c == C - 1) {
                result = Math.min(result, cur.t);
            }
            for (int i = 0; i < 4; i++) {
                N next = cur.move(dd[i][0], dd[i][1]);
                if (next.isInBoard()) {
                    if (vis[next.has ? 1 : 0][next.r][next.c] > next.t) {
                        if (arr[next.r][next.c] != 1 || (arr[next.r][next.c] == 1 && next.has)) {
                            if (arr[next.r][next.c] == 2)
                                next.has = true;
                            q.offer(next);
                            vis[next.has ? 1 : 0][next.r][next.c] = next.t;
                        }
                    }
                }
            }
        }
        bw.write(result <= T ? result + "" : "Fail");
        bw.close();
        br.close();
    }

    static class N {
        int r;
        int c;
        int t;
        boolean has;

        N(int rr, int cc, int tt, boolean hass) {
            r = rr;
            c = cc;
            t = tt;
            has = hass;
        }

        N(int rr, int cc, int tt) {
            r = rr;
            c = cc;
            t = tt;
            has = false;
        }

        N move(int r, int c) {
            return new N(this.r + r, this.c + c, t + 1, has);
        }

        boolean isInBoard() {
            return r >= 0 && c >= 0 && r < R && c < C;
        }
    }
}