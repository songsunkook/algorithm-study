import java.io.*;
import java.util.*;

class Main {
    static int R, C;
    static int[][] arr;
    static boolean[][] vis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[R][C];
        vis = new boolean[R][C];
        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < C; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (arr[r][c] != 0 && !vis[r][c]) {
                    if (check(r, c))
                        count++;
                }
            }
        }

        bw.write(count + "");
        bw.close();
        br.close();
    }

    static int[][] drc = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };

    static boolean check(int startR, int startC) {
        boolean isPeak = true;
        Queue<P> q = new LinkedList<>();
        q.offer(new P(startR, startC));
        vis[startR][startC] = true;
        while (!q.isEmpty()) {
            P cur = q.poll();
            for (var tmp : drc) {
                P nex = new P(cur.r + tmp[0], cur.c + tmp[1]);
                if (nex.inBoard()) {
                    if (arr[nex.r][nex.c] > arr[cur.r][cur.c]) {
                        isPeak = false;
                    } else if (!vis[nex.r][nex.c] && arr[nex.r][nex.c] == arr[cur.r][cur.c]) {
                        q.offer(nex);
                        vis[nex.r][nex.c] = true;
                    }
                }
            }
        }
        return isPeak;
    }

    static class P {
        int r;
        int c;

        P(int rr, int cc) {
            r = rr;
            c = cc;
        }

        boolean inBoard() {
            return r >= 0 && c >= 0 && r < R && c < C;
        }
    }
}