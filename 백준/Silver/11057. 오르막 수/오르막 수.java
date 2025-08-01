import java.io.*;
import java.util.*;

class Main {
    /**
     * 0000
     * 1111
     * 1234
     * 
     * 앞의 수는 뒤의 수에 의존적이다.
     * 뒷자리 수를 기반으로 진행해야 한다.
     * 
     * n = 1
     * 0
     * 1
     * 2
     * 
     * n = 2
     * 00
     * 01 11
     * 02 12 22
     * 
     * n = 3
     * 000
     * 001 011 111
     * 002 012 022 112 122 222
     * 
     * n = 4
     * 0000
     * 0001 0011 0111 1111
     * 0002 0012 0022 0112 0122 0222 1112 1122 1222 2222
     * 
     * dp[n][i] = n자리 수에서 끝이 i일 때 경우의 수
     * 1 2 3 4(n)
     * 0 1 1 1 1
     * 1 1 1 3 4
     * 2 1 2 6 10
     * (i)
     * 
     * dp[n][i] = dp[n-1][i] + dp[n][i-1]
     * 
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n + 1][10];
        Arrays.fill(dp[1], 1);
        for (int i = 2; i <= n; i++) {
            dp[i][0] = 1;
            for (int digit = 1; digit < 10; digit++) {
                dp[i][digit] = (dp[i - 1][digit] + dp[i][digit - 1]) % 10007;
            }
        }
        long sum = 0;
        for (int i = 0; i <= 9; i++) {
            sum += dp[n][i] % 10007;
        }
        bw.write(sum % 10007 + "");
        bw.close();
        br.close();
    }
}