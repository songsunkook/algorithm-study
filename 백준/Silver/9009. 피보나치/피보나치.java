import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 피보나치 수열 구하기
        long[] dp = new long[50];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < 50; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        // for (int i = 0; i < 50; i++)
        // bw.write(dp[i] + " ");

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            Stack<Long> result = new Stack<>();
            int n = Integer.parseInt(br.readLine());

            int idx = 49;
            while (n > 0) {
                if (n >= dp[idx]) {
                    n -= dp[idx];
                    result.push(dp[idx]);
                }
                idx--;
            }

            while (!result.isEmpty())
                bw.write(result.pop() + " ");
            bw.write("\n");
        }

        bw.close();
        br.close();
    }
}