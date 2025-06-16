import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        if (n == 0) {
            bw.write("0");
            bw.close();
            br.close();
            return;
        }
        dp = new int[100001];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 1;
        dp[2] = 1;
        dp[5] = 1;
        dp[7] = 1;
        func(n);
        bw.write(dp[n] + "");
        bw.close();
        br.close();
    }

    static int func(int a) {
        if (dp[a] != Integer.MAX_VALUE)
            return dp[a];
        if (can(a - 1))
            dp[a] = Math.min(dp[a], func(a - 1) + 1);
        if (can(a - 2))
            dp[a] = Math.min(dp[a], func(a - 2) + 1);
        if (can(a - 5))
            dp[a] = Math.min(dp[a], func(a - 5) + 1);
        if (can(a - 7))
            dp[a] = Math.min(dp[a], func(a - 7) + 1);
        return dp[a];
    }

    static boolean can(int a) {
        return a <= n && a >= 0;
    }
}