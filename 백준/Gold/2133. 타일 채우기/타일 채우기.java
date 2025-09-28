import java.io.*;
import java.util.*;

class Main {
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        if (n % 2 == 1) {
            bw.write(0 + "");
            bw.close();
            br.close();
            return;
        }

        dp = new int[n + 4];
        dp[0] = 1;
        dp[1] = 0;
        dp[2] = 3;
        for (int i = 3; i <= n; i++) {
            dp[i] = 3 * d(i - 2) + 2 * dl(i - 4);
        }

        bw.write(dp[n] + "");
        bw.close();
        br.close();
    }

    static int d(int a) {
        if (a < 0)
            return 0;
        return dp[a];
    }

    static int dl(int a) {
        if (a % 2 == 1)
            return 0;
        int result = 0;
        while (a >= 0) {
            result += dp[a];
            a -= 2;
        }
        return result;
    }
}