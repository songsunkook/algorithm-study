import java.io.*;
import java.util.*;

class Main {

    static int R, C, max;
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[R][C];
        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            int col = 0;
            for (var c : input.toCharArray()) {
                arr[i][col] = c;
                col++;
            }
        }

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (arr[r][c] == 'L') {
                    max = Math.max(max, bfs(r, c));
                }
            }
        }
        bw.write(max + "");

        bw.close();
        br.close();
    }

    static int[][] drc = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

    static int bfs(int r, int c) {
        Queue<P> q = new LinkedList<>();
        boolean[][] vis = new boolean[R][C];
        vis[r][c] = true;
        q.offer(new P(r, c, 0));
        int maxDist = 0;
        while (!q.isEmpty()) {
            P cur = q.poll();
            maxDist = Math.max(maxDist, cur.dist);
            for (var z : drc) {
                P n = new P(cur.r + z[0], cur.c + z[1], cur.dist + 1);
                if (n.isInBoard() && arr[n.r][n.c] == 'L' && !vis[n.r][n.c]) {
                    vis[n.r][n.c] = true;
                    q.offer(n);
                    // System.out.printf("[%d, %d] ", n.r, n.c);
                }
            }
        }
        return maxDist;
    }

    static class P {
        int r;
        int c;
        int dist;

        P(int rr, int cc, int d) {
            r = rr;
            c = cc;
            dist = d;
        }

        boolean isInBoard() {
            return r >= 0 && c >= 0 && r < R && c < C;
        }
    }
}