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
        int depth = -1;
        Queue<P> q = new LinkedList<>();
        boolean[][] vis = new boolean[R][C];
        vis[r][c] = true;
        q.offer(new P(r, c));
        // System.out.printf("[%d, %d] ", r, c);
        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                P cur = q.poll();
                for (var z : drc) {
                    P n = new P(cur.r + z[0], cur.c + z[1]);
                    if (n.isInBoard() && arr[n.r][n.c] == 'L' && !vis[n.r][n.c]) {
                        vis[n.r][n.c] = true;
                        q.offer(n);
                        // System.out.printf("[%d, %d] ", n.r, n.c);
                    }
                }
            }
            depth++;
        }
        return depth;
    }

    static class P {
        int r;
        int c;

        P(int rr, int cc) {
            r = rr;
            c = cc;
        }

        boolean isInBoard() {
            return r >= 0 && c >= 0 && r < R && c < C;
        }
    }
}