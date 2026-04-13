import java.io.*;
import java.util.*;

class Main {

    static boolean[][] arr = new boolean[10][10];
    static int[] paper = { 0, 5, 5, 5, 5, 5 };
    static int min = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int r = 0; r < 10; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < 10; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken()) == 1;
            }
        }
        dfs(0);
        if (min == 100) {
            min = -1;
        }
        bw.write(min + "");
        bw.close();
        br.close();
    }

    static void dfs(int cnt) {
        for (int r = 0; r < 10; r++) {
            for (int c = 0; c < 10; c++) {
                if (arr[r][c]) {
                    for (int s = 5; s >= 1; s--) {
                        if (can(r, c, s)) {
                            put(r, c, s, true);
                            dfs(cnt + 1);
                            put(r, c, s, false);
                        }
                    }
                    return;
                }
            }
        }
        min = Math.min(min, cnt);
    }

    static boolean can(int rr, int cc, int s) {
        if (!(paper[s] > 0 && rr >= 0 && cc >= 0 && rr + s <= 10 && cc + s <= 10)) {
            return false;
        }
        for (int r = rr; r < rr + s; r++) {
            for (int c = cc; c < cc + s; c++) {
                if (!arr[r][c]) {
                    return false;
                }
            }
        }
        return true;
    }

    static void put(int rr, int cc, int s, boolean flag) {
        paper[s] += flag ? -1 : 1;
        for (int r = rr; r < rr + s; r++) {
            for (int c = cc; c < cc + s; c++) {
                arr[r][c] = !flag;
            }
        }
    }
}