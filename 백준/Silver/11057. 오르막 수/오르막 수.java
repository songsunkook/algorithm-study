import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n][10];
        Arrays.fill(dp[0], 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j] % 10007;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i <= 9; i++) {
            sum += dp[n - 1][i] % 10007;
        }
        bw.write(sum % 10007 + "");
        bw.close();
        br.close();
    }
}