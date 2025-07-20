import java.io.*;
import java.util.*;

class Main {
    /**
     * 1 -> 0 1 2 3 4 5 6 7 8 9
     * 2 -> 00 01~11 01~22 01~33(01 02 ..) ... 01~88 01~99
     * 3 -> 000 001~111 001~222 001~333 ... 001~999
     * 
     * dp[1] = 10
     * dp[2] = 10 + 9 + 8 + ... + 2 + 1 (dp[1]!)
     * dp[3] = sum(dp[2]) + (dp[3][0] - dp[2][0]) + (dp[3][1] - dp[2][1])
     * 
     * dp[i][j] = dp[i][j-1] - dp[i-1][j-1];
     * 
     * result = sum(dp[n][i])
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n + 1][10];
        Arrays.fill(dp[1], 1);
        for (int i = 2; i <= n; i++) {
            dp[i][0] = 1;
            for (int j = 1; j < 10; j++) {
                dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % 10007;
            }
        }
        long sum = 0;
        for (int i = 0; i < 10; i++)
            sum += dp[n][i] % 10007;

        bw.write(sum % 10007 + "");
        bw.close();
        br.close();
    }
}