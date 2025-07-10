import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        long[][] dp = new long[n + 1][3];
        dp[1][0] = 0;// n = 1 , mod = 0
        dp[1][1] = 1;
        dp[1][2] = 1;
        for (int i = 1; i < n; i++) {
            for (int mod = 0; mod < 3; mod++) {
                for (int digit = 0; digit <= 2; digit++) {
                    int nextMod = (mod + digit) % 3;
                    dp[i + 1][nextMod] = (dp[i + 1][nextMod] + dp[i][mod]) % 1000000009;
                }
            }
        }
        bw.write(dp[n][0] + "");
        bw.close();
        br.close();
    }
}