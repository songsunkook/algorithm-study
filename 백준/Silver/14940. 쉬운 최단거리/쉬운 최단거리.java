import java.io.*;
import java.util.*;

class Main {

    static int R, C;
    static int[][] drc = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int[][] arr = new int[R][C];

        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < C; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] result = new int[R][C];

        Queue<P> q = new LinkedList<>();
        boolean[][] v = new boolean[R][C];
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (arr[r][c] == 2) {
                    q.offer(new P(r, c, 0));
                    v[r][c] = true;
                }
                if (arr[r][c] == 0)
                    result[r][c] = 0;
                else
                    result[r][c] = -1;
            }
        }
        
        while (!q.isEmpty()) {
            P cur = q.poll();
            result[cur.r][cur.c] = cur.d;
            for (int i = 0; i < 4; i++) {
                P n = new P(cur.r + drc[i][0], cur.c + drc[i][1], cur.d + 1);
                if (n.inBoard() && arr[n.r][n.c] == 1 && !v[n.r][n.c]) {
                    q.offer(n);
                    v[n.r][n.c] = true;
                }
            }
        }

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                bw.write(result[r][c] + " ");
            }
            bw.write("\n");
        }

        bw.close();
        br.close();
    }

    static class P {
        int r;
        int c;
        int d;

        P(int rr, int cc, int dd) {
            r = rr;
            c = cc;
            d = dd;
        }

        boolean inBoard() {
            return r >= 0 && c >= 0 && r < R && c < C;
        }
    }
}