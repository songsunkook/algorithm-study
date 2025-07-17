import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long[][] dp = new long[1001][10];
        int T = Integer.parseInt(br.readLine());
        Arrays.fill(dp[1], 1);
        for (int t = 0; t < T; t++) {
            int TIME = Integer.parseInt(br.readLine());
            for (int time = 2; time <= TIME; time++) {
                if (dp[time][0] != 0)
                    continue;
                for (int num = 0; num < 10; num++) {
                    for (int side : getSide(num)) {
                        dp[time][num] += dp[time - 1][side] % 1234567;
                    }
                }
            }
            long sum = 0;
            for (int i = 0; i < 10; i++)
                sum += dp[TIME][i] % 1234567;
            bw.write(sum % 1234567 + "\n");
        }
        bw.close();
        br.close();
    }

    static int[][] dd = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
    static int[][] board = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 0, -1, -1 } };

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