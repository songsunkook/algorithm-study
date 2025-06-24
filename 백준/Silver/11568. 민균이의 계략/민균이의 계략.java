import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int r = 1; r < n; r++) {
            for (int l = 0; l < r; l++) {
                if (arr[l] < arr[r])
                    dp[r] = Math.max(dp[r], dp[l] + 1);
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++)
            max = Math.max(max, dp[i]);
        bw.write(max + "");
        bw.close();
        br.close();
    }
}