import java.io.*;
import java.util.*;

class Main {
    static int R, C, k, count = 0;
    static boolean[][] arr, vis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new boolean[R][C];
        vis = new boolean[R][C];
        for (int r = 0; r < R; r++) {
            String line = br.readLine();
            for (int c = 0; c < C; c++) {
                arr[r][c] = line.charAt(c) == '.';
            }
        }
        if (!arr[R - 1][0]) {
            bw.write("0");
            bw.close();
            br.close();
            return;
        }
        if (R == 1 && C == 1) {
            if (arr[0][0] && k == 1) {
                bw.write("1");
            } else {
                bw.write("0");
            }
            bw.close();
            br.close();
            return;
        }
        vis[R-1][0] = true;
        dfs(R - 1, 0, 1);
        bw.write(count + "");
        bw.close();
        br.close();
    }

    static void dfs(int r, int c, int depth) {
        if (r == 0 && c == C - 1) {
            if (depth == k)
                count++;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nr = r + dd[i][0];
            int nc = c + dd[i][1];
            if (inBoard(nr, nc) && !vis[nr][nc] && arr[nr][nc]) {
                vis[nr][nc] = true;
                dfs(nr, nc, depth + 1);
                vis[nr][nc] = false;
            }
        }
    }

    static int[][] dd = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

    static boolean inBoard(int r, int c) {
        return r >= 0 && c >= 0 && r < R && c < C;
    }
}