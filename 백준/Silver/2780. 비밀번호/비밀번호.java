import java.io.*;
import java.util.*;

class Main {
    static int[][] dd = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
    static int[][] board = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 0, -1, -1 } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        long[][] dp = new long[1001][10];
        Arrays.fill(dp[1], 1L);

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());

            for (int i = 2; i <= n; i++) {
                if (dp[i][9] != 0)
                    continue;
                for (int j = 0; j < 10; j++) {
                    for (int side : getSide(j)) {
                        dp[i][j] += dp[i - 1][side] % 1234567;
                    }
                    dp[i][j] %= 1234567;
                }
            }

            long total = 0;
            for (int i = 0; i < 10; i++)
                total += dp[n][i];
            total %= 1234567;
            bw.write(total + "\n");
        }

        bw.close();
        br.close();
    }

    static List<Integer> getSide(int num) {
        int r = 0, c = 0;
        for (int i = 0; i < 10; i++) {
            r = i / 3;
            c = i % 3;
            if (board[r][c] == num)
                break;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int nr = r + dd[i][0];
            int nc = c + dd[i][1];
            if (in(nr, nc)) {
                res.add(board[nr][nc]);
            }
        }
        return res;
    }

    static boolean in(int r, int c) {
        if (r == 3 && c > 0)
            return false;
        return r >= 0 && c >= 0 && r <= 3 && c < 3;
    }
}