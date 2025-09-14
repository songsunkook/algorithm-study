import java.io.*;
import java.util.*;

/*
 * 불연속
 * dp[i] = i번째 집까지를 칠하는 최소값
 * dp[i][j] = i번째 집을 j색으로 칠하는 최소값
 * i=0~n-1, j=0~2
 * dp[i][j] = (not equals j) min(dp[i-1][a], dp[i-1][b]) + cur (r이면 gb 중 작은 값 + r)
 */
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][3];
        int[][] dp = new int[n][3];
        for (int i = 0; i < n; i++)
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        dp[0][2] = arr[0][2];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                int o = (j + 1) % 3;
                // dp[i][j] = Math.min(dp[i - 1][o], dp[i][j]) + arr[i][j];
                // o = (o + 1) % 3;
                // dp[i][j] = Math.min(dp[i - 1][o] + arr[i][j], dp[i][j]);
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + arr[i][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + arr[i][1];
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + arr[i][2];
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            min = Math.min(dp[n - 1][i], min);
        }
        bw.write(min + "");
        bw.close();
        br.close();
    }
}