import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n + 1][10]; // idx , mod
        dp[1][0] = 0;
        dp[1][1] = 1;
        dp[1][2] = 1;
        for (int i = 2; i <= n; i++) {
            for (int befD = 0; befD <= 2; befD++) {
                for (int d = 0; d <= 2; d++) {
                    int mod = (befD + d) % 3;
                    dp[i][mod] = dp[i][mod] + dp[i - 1][befD] % 1000000009;
                }
            }
        }
        bw.write(dp[n][0] % 1000000009 + "");
        bw.close();
        br.close();
    }
}