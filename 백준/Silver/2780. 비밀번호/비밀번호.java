import java.io.*;
import java.util.*;

class Main {
    /**
     * 1 2 3
     * 4 5 6
     * 7 8 9
     * 0
     * 
     * for(i = 0 ~ 9)
     * for(a = adj(i))
     * dp[cur][i] += dp[cur-1][a]
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[1001][10];
        Arrays.fill(dp[1], 1);
        for (int i = 0; i < n; i++) {
            int count = Integer.parseInt(br.readLine());
            for (int turn = 2; turn <= count; turn++) {
                if (dp[turn][0] != 0)
                    continue;
                for (int digit = 0; digit <= 9; digit++) {
                    for (var adjDigit : adj(digit)) {
                        dp[turn][digit] += dp[turn - 1][adjDigit] % 1234567;
                    }
                }
            }
            long sum = 0;
            for (int digit = 0; digit < 10; digit++)
                sum += dp[count][digit] % 1234567;
            bw.write(sum % 1234567 + "\n");
        }

        bw.close();
        br.close();
    }

    static int[][] dd = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
    static int[][] pad = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 0, -1, -1 } };

    static List<Integer> adj(int n) {
        List<Integer> result = new ArrayList<>();
        if (n == 0)
            return List.of(7);
        if (n == 7)
            return List.of(4, 8, 0);
        int r = (n - 1) / 3;
        int c = (n - 1) % 3;
        for (int i = 0; i < 4; i++) {
            int nr = r + dd[i][0];
            int nc = c + dd[i][1];
            if (nr >= 3 || nc >= 3 || nr < 0 || nc < 0 || pad[nr][nc] == -1)
                continue;
            result.add(pad[nr][nc]);
        }
        return result;
    }
}