import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int[][] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n][2];
            dp = new int[n][2];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i][0] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i][1] = Integer.parseInt(st.nextToken());
            }

            dp[0][0] = arr[0][0];
            dp[0][1] = arr[0][1];
            if (n > 1) {
                dp[1][0] = arr[1][0] + arr[0][1];
                dp[1][1] = arr[1][1] + arr[0][0];
            }
            for (int i = 2; i < n; i++) {
                dp[i][0] = arr[i][0] + Math.max(dp[i - 1][1], Math.max(dp[i - 2][0], dp[i - 2][1]));
                dp[i][1] = arr[i][1] + Math.max(dp[i - 1][0], Math.max(dp[i - 2][0], dp[i - 2][1]));
            }

            bw.write(Math.max(dp[n - 1][0], dp[n - 1][1]) + "\n");
        }

        bw.close();
        br.close();
    }
}