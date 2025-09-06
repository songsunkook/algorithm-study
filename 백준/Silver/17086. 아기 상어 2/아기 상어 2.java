import java.io.*;
import java.util.*;

class Main {

    static int R, C;
    static boolean[][] arr;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new boolean[R][C];
        dist = new int[R][C];
        for (int r = 0; r < R; r++)
            Arrays.fill(dist[r], Integer.MAX_VALUE);
        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < C; c++) {
                arr[r][c] = st.nextToken().equals("1") ? true : false;
            }
        }

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (arr[r][c]) {
                    func(r, c);
                }
            }
        }

        int max = 0;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (dist[r][c] != Integer.MAX_VALUE)
                    max = Math.max(max, dist[r][c]);
            }
        }
        bw.write(max + "");
        bw.close();
        br.close();
    }

    static int[][] dd = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };

    static void func(int sr, int sc) {
        boolean[][] vis = new boolean[R][C];
        Queue<P> q = new LinkedList<>();
        q.offer(new P(sr, sc, 0));
        vis[sr][sc] = true;
        while (!q.isEmpty()) {
            P cur = q.poll();
            for (int[] d : dd) {
                P next = new P(cur.r + d[0], cur.c + d[1], cur.d + 1);
                if (next.r < 0 || next.c < 0 || next.r >= R || next.c >= C || vis[next.r][next.c]) {
                    continue;
                }
                if (dist[next.r][next.c] > cur.d && !arr[next.r][next.c]) {
                    q.offer(next);
                    vis[next.r][next.c] = true;
                    dist[next.r][next.c] = next.d;
                }
            }
        }
    }

    static class P {
        int r, c, d;

        P(int rr, int cc, int dd) {
            r = rr;
            c = cc;
            d = dd;
        }
    }
}
// 2:15~