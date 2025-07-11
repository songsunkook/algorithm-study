import java.io.*;
import java.util.*;

class Main {
    static int n;
    static Boolean[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        dp = new Boolean[n + 1];
        dp[1] = false;
        if (n >= 2)
            dp[2] = true;
        if (n >= 3)
            dp[3] = false; // 1 -> 1 -> 1
        if (n >= 4)
            dp[4] = true; // 3 -> 1
        bw.write(func(n) ? "SK" : "CY");
        bw.close();
        br.close();
    }

    static int[] dd = { 4, 3, 1 };

    static boolean func(int num) {
        if (dp[num] != null)
            return dp[num];

        for (int d : dd) {
            if (!func(num - d)) {
                dp[num] = true;
                return true;
            }
        }
        dp[num] = false;
        return false;
    }
}