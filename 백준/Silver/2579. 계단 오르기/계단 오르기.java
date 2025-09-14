import java.io.*;
import java.util.*;

/*
 * dp[i] = i번째 계단을 밟는 가장 큰 값
 * dp[i] = Math.max(dp[i-1], dp[i-2]);
 * 
 * dp[i][j] = i번째 계단을 j번째로 밟는 가장 큰 값
 * dp[i][0] = Math.max(dp[i-1][1], dp[i-1][2])
 * dp[i][1] = Math.max(dp[i-1][0], dp[i-2][1], dp[i-2],[2]) + now
 * dp[i][2] = dp[i-1][1] + now
 * 
 * answer: Math.max(dp[n-1][1], dp[n-1][2])
 */
class Main {
    static int[] arr;
    static Integer[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new Integer[n][3];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        if (n >= 1) {
            dp[0][0] = 0;
            dp[0][1] = arr[0];
            dp[0][2] = -10000000;
        }
        if (n >= 2) {
            dp[1][0] = arr[0];
            dp[1][1] = arr[1];
            dp[1][2] = arr[0] + arr[1];
        }
        int ans = Math.max(func(n - 1, 1), func(n - 1, 2));
        bw.write(ans + "");
        bw.close();
        br.close();
    }

    static int func(int i, int j) {
        if (dp[i][j] != null)
            return dp[i][j];
        dp[i][0] = Math.max(func(i - 1, 1), func(i - 1, 2));
        dp[i][1] = Math.max(func(i - 1, 0), Math.max(func(i - 2, 1), func(i - 2, 2))) + arr[i];
        dp[i][2] = func(i - 1, 1) + arr[i];
        return dp[i][j];
    }
}