import java.io.*;
import java.util.*;

class Main {
    static char[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String line = br.readLine();
        int[] dp = new int[n];
        arr = line.toCharArray();
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (can(j, i) && dp[j] != Integer.MAX_VALUE)
                    dp[i] = Math.min(dp[i], dp[j] + (i - j) * (i - j));
            }
        }
        bw.write((dp[n - 1] == Integer.MAX_VALUE ? -1 : dp[n - 1]) + "");
        bw.close();
        br.close();
    }

    static boolean can(int i, int j) {
        switch (arr[i]) {
            case 'B':
                return arr[j] == 'O';
            case 'O':
                return arr[j] == 'J';
            case 'J':
                return arr[j] == 'B';
            default:
                return false;
        }
    }
}