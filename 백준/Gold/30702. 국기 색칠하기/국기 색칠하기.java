import java.io.*;
import java.util.*;

class Main {
    static int R, C;
    static int[][] before, after;
    static boolean[][] vis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        before = new int[R][C];
        after = new int[R][C];
        vis = new boolean[R][C];
        for (int r = 0; r < R; r++) {
            String line = br.readLine();
            for (int c = 0; c < C; c++) {
                before[r][c] = line.charAt(c) - 'A';
            }
        }
        for (int r = 0; r < R; r++) {
            String line = br.readLine();
            for (int c = 0; c < C; c++) {
                after[r][c] = line.charAt(c) - 'A';
            }
        }

        boolean result = true;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (!vis[r][c]) {
                    result &= bfs(r, c);
                }
                if (!result)
                    break;
            }
            if (!result)
                break;
        }

        bw.write(result ? "YES" : "NO");
        bw.close();
        br.close();
    }

    static int[][] dd = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

    static boolean bfs(int sr, int sc) {
        int sb = before[sr][sc];
        int sa = after[sr][sc];
        Queue<N> q = new LinkedList<>();
        q.offer(new N(sr, sc));
        vis[sr][sc] = true;
        while (!q.isEmpty()) {
            N cur = q.poll();
            for (int i = 0; i < 4; i++) {
                N next = new N(cur.r + dd[i][0], cur.c + dd[i][1]);
                if (next.isIn() && !vis[next.r][next.c]) {
                    if (before[next.r][next.c] == sb) {
                        if (after[next.r][next.c] != sa) {
                            return false;
                        }
                        vis[next.r][next.c] = true;
                        q.offer(next);
                    }
                }
            }
        }
        return true;
    }

    static class N {
        int r;
        int c;

        N(int rr, int cc) {
            r = rr;
            c = cc;
        }

        boolean isIn() {
            return r >= 0 && c >= 0 && r < R && c < C;
        }
    }
}