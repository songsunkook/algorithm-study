import java.io.*;
import java.util.*;

class Main {
    static int R, C, k;
    static int kr, kc;
    static Long[][] dp;
    static boolean[][] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        dp = new Long[R][C];
        v = new boolean[R][C];
        if (k != 0) {
            kr = (k - 1) / C;
            kc = (k - 1) % C;
        }
        dp[0][0] = 0L;
        bw.write(func(0, 0, false) + "");
        bw.close();
        br.close();
    }

    static long func(int r, int c, boolean vis) {
        if (r == R - 1 && c == C - 1) {
            return vis ? 1L : 0L;
        }
        if (v[r][c])
            return dp[r][c];

        if (r == kr && c == kc)
            vis = true;

        v[r][c] = true;
        long cnt = 0;
        if (in(r, c + 1) && !v[r][c + 1])
            cnt += func(r, c + 1, vis);
        if (in(r + 1, c) && !v[r + 1][c])
            cnt += func(r + 1, c, vis);
        v[r][c] = false;
        dp[r][c] = cnt;
        return dp[r][c];
    }

    static boolean in(int r, int c) {
        return r >= 0 && c >= 0 && r < R && c < C;
    }
}