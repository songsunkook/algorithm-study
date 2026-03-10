import java.io.*;
import java.util.*;

class Main {
    static int R, C;
    static boolean[][] arr, vis;
    static int[][] dd = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new boolean[R][C];
        vis = new boolean[R][C];
        for (int r = 0; r < R; r++) {
            String line = br.readLine();
            int i = 0;
            for (char a : line.toCharArray()) {
                arr[r][i] = a == '1';
                i++;
            }
        }

        Queue<N> q = new LinkedList<>();
        q.offer(new N(0, 0, 1));
        vis[0][0] = true;
        while (!q.isEmpty()) {
            N cur = q.poll();
            if (cur.r == R - 1 && cur.c == C - 1) {
                bw.write(cur.d + "");
                break;
            }
            for (int[] d : dd) {
                int nr = cur.r + d[0];
                int nc = cur.c + d[1];
                if (nr >= R || nr < 0 || nc >= C || nc < 0 || !arr[nr][nc] || vis[nr][nc]) {
                    continue;
                }
                vis[nr][nc] = true;
                q.offer(new N(nr, nc, cur.d + 1));
            }
        }
        bw.close();
        br.close();
    }

    static class N {
        int r;
        int c;
        int d;

        N(int rr, int cc, int dd) {
            r = rr;
            c = cc;
            d = dd;
        }
    }
}