import java.io.*;
import java.util.*;

class Main {
    static int R, C;
    static boolean[][] arr, vis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new boolean[R][C];
        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < C; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken()) == 1 ? true : false;
            }
        }

        int count = 0;
        vis = new boolean[R][C];
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (!vis[r][c] && arr[r][c]) {
                    count++;
                    dfs(r, c);
                }
            }
        }

        bw.write(count + "");
        bw.close();
        br.close();
    }

    static int[][] dd = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };

    static void dfs(int r, int c) {
        vis[r][c] = true;
        for (int i = 0; i < 8; i++) {
            int nr = r + dd[i][0];
            int nc = c + dd[i][1];
            if (nr < 0 || nr >= R || nc < 0 || nc >= C)
                continue;
            if (!vis[nr][nc] && arr[nr][nc])
                dfs(nr, nc);
        }
    }
}