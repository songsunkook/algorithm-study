import java.io.*;
import java.util.*;

class Main {
    static int[] arr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n + 1];
        dp = new int[n + 1];
        Arrays.fill(dp, 1000000000);
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= n; i++) {
            dp[i] = Math.min(arr[i], min(i));
        }
        bw.write(dp[n] + "");

        bw.close();
        br.close();
    }

    static int min(int num) {
        int m = Integer.MAX_VALUE;
        for (int i = 0; i <= num; i++) {
            m = Math.min(m, dp[i] + dp[num - i]);
        }
        return m;
    }
}