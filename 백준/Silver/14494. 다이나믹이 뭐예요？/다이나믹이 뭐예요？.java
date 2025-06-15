import java.io.*;
import java.util.*;

class Main {
    static int R, C;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        dp = new long[R][C];

        bw.write(func(0, 0) + "");
        bw.close();
        br.close();
    }

    static long func(int r, int c) {
        if (dp[r][c] != 0)
            return dp[r][c];
        if (r == R - 1 && c == C - 1)
            return 1;
        long sum = 0;
        if (r + 1 < R)
            sum = (sum + func(r + 1, c)) % 1000000007;
        if (c + 1 < C)
            sum = (sum + func(r, c + 1)) % 1000000007;
        if (r + 1 < R && c + 1 < C)
            sum = (sum + func(r + 1, c + 1)) % 1000000007;
        dp[r][c] = sum;
        // System.out.println("{" + r + ", " + c + "}: " + sum);
        return dp[r][c];
    }
}