import java.io.*;
import java.util.*;

class Main {

    static int[] paper = new int[6];
    static boolean[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        arr = new boolean[10][10];
        Arrays.fill(paper, 5);
        for (int r = 0; r < 10; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < 10; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken()) == 1;
            }
        }

        int cnt = dfs();
        bw.write(cnt == Integer.MAX_VALUE ? "-1" : (cnt + ""));
        bw.close();
        br.close();
    }

    static int dfs() {
        int min = Integer.MAX_VALUE;
        boolean clear = true;
        for (int r = 0; r < 10; r++) {
            for (int c = 0; c < 10; c++) {
                if (arr[r][c]) {
                    clear = false;
                    for (int s = 5; s >= 1; s--) {
                        if (can(r, c, s)) {
                            put(r, c, s, false);
                            int res = dfs();
                            if (res != Integer.MAX_VALUE) {
                                min = Math.min(min, res + 1);
                            }
                            put(r, c, s, true);
                        }
                    }
                    return min;
                }
            }
        }
        if (clear) {
            return 0;
        }
        return min;
    }

    static boolean can(int r, int c, int s) {
        if (paper[s] <= 0) {
            return false;
        }
        if (r < 0 || r + s > 10 || c < 0 || c + s > 10) {
            return false;
        }
        for (int nr = r; nr < r + s; nr++) {
            for (int nc = c; nc < c + s; nc++) {
                if (!arr[nr][nc]) {
                    return false;
                }
            }
        }
        return true;
    }

    static void put(int r, int c, int s, boolean flag) {
        if (flag) {
            paper[s]++;
        } else {
            paper[s]--;
        }
        for (int nr = r; nr < r + s; nr++) {
            for (int nc = c; nc < c + s; nc++) {
                arr[nr][nc] = flag;
            }
        }
    }
}