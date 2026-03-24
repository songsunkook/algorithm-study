import java.io.*;
import java.util.*;

class Main {

    static int n;
    static boolean[] co, d1, d2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        co = new boolean[n];
        d1 = new boolean[2 * n];
        d2 = new boolean[2 * n];

        bw.write(dfs(0) + "");
        bw.close();
        br.close();
    }

    static int dfs(int r) {
        if (r == n) {
            return 1;
        }
        int cnt = 0;
        for (int c = 0; c < n; c++) {
            if (can(r, c)) {
                put(r, c, true);
                cnt += dfs(r + 1);
                put(r, c, false);
            }
        }
        return cnt;
    }

    static boolean can(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < n &&
                !co[c] && !d1[r + c] && !d2[r - c + n - 1];
    }

    static void put(int r, int c, boolean flag) {
        co[c] = flag;
        d1[r + c] = flag;
        d2[r - c + n - 1] = flag;
    }
}