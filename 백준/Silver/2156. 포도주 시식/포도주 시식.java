import java.io.*;
import java.util.*;

/*
 * dp[i] = i번째 포도주를 마시는 가장 큰 값
 * dp[i] = Math.max(dp[i-2] + arr[i], dp[i-3] + arr[i-1] + arr[i])
 */

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) {
            bw.write(arr[0] + "");
        } else if (n == 2) {
            bw.write(arr[0] + arr[1] + "");
        } else if (n == 3) {
            bw.write(Math.max(Math.max(arr[0] + arr[2], arr[1] + arr[2]), arr[0] + arr[1]) + "");
        } else {
            dp[0] = arr[0];
            dp[1] = arr[0] + arr[1];
            dp[2] = Math.max(arr[0] + arr[2], arr[1] + arr[2]);
            dp[2] = Math.max(dp[2], arr[0] + arr[1]);
            dp[3] = Math.max(dp[0] + arr[2] + arr[3], dp[1] + arr[3]);
            for (int i = 4; i < n; i++) {
                // int max = 0;
                // for (int j = 0; j < i; j++) {
                // max = Math.max(max, dp[i]);
                // }
                dp[i] = Math.max(dp[i - 3] + arr[i - 1] + arr[i], dp[i - 2] + arr[i]);
                dp[i] = Math.max(dp[i], dp[i - 4] + arr[i - 1] + arr[i]);
                // dp[i] = Math.max(max - arr[i-1] + arr[i], max);
            }
            bw.write(Math.max(dp[n - 1], dp[n - 2]) + "");
        }

        bw.close();
        br.close();
    }
}