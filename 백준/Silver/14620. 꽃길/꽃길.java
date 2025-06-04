import java.io.*;
import java.util.*;

class Main {

    static int n, min = Integer.MAX_VALUE;
    static int[][] arr;
    static boolean[][] vis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        vis = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (inBoard(i, j) && !checkVis(i, j))
                    find(i, j, 0);
            }
        }

        bw.write(min + "");
        bw.close();
        br.close();
    }

    static void find(int r, int c, int cnt) {
        if (cnt == 3) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (vis[i][j])
                        sum += arr[i][j];
                }
            }
            min = Math.min(min, sum);
            return;
        }
        for (int j = c; j < n; j++) {
            if (inBoard(r, j) && !checkVis(r, j)) {
                updateVis(r, j, true);
                find(r, j, cnt + 1);
                updateVis(r, j, false);
            }
        }
        for (int i = r + 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (inBoard(i, j) && !checkVis(i, j)) {
                    updateVis(i, j, true);
                    find(i, j, cnt + 1);
                    updateVis(i, j, false);
                }
            }
        }
    }

    static boolean inBoard(int r, int c) {
        return r - 1 >= 0 && r + 1 < n && c - 1 >= 0 && c + 1 < n;
    }

    static boolean checkVis(int r, int c) {
        return vis[r][c] || vis[r - 1][c] || vis[r + 1][c] || vis[r][c - 1] || vis[r][c + 1];
    }

    static void updateVis(int r, int c, boolean value) {
        vis[r][c] = value;
        vis[r - 1][c] = value;
        vis[r + 1][c] = value;
        vis[r][c - 1] = value;
        vis[r][c + 1] = value;
    }
}