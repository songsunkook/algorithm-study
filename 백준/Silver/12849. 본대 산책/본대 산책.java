import java.io.*;
import java.util.*;

class Main {

    /**
     * 0 정보과학관
     * 1 전산관
     * 2 미래관
     * 3 신양관
     * 4 진리관
     * 5 한경직기념관
     * 6 학생회관
     * 7 형남공학관
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Integer>[] adj = new List[8];
        for (int i = 0; i < 8; i++) {
            adj[i] = new ArrayList<>();
        }
        adj[0].addAll(List.of(1, 2));
        adj[1].addAll(List.of(0, 2, 3));
        adj[2].addAll(List.of(0, 1, 3, 5));
        adj[3].addAll(List.of(1, 2, 4, 5));
        adj[4].addAll(List.of(3, 5, 6));
        adj[5].addAll(List.of(2, 3, 4, 7));
        adj[6].addAll(List.of(4, 7));
        adj[7].addAll(List.of(5, 6));
        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n + 1][8];
        dp[0][0] = 1;
        for (int t = 1; t <= n; t++) {
            for (int i = 0; i < 8; i++) {
                for (int ad : adj[i]) {
                    dp[t][i] += dp[t - 1][ad] % 1000000007;
                }
            }
        }
        bw.write(dp[n][0] % 1000000007 + "");
        bw.close();
        br.close();
    }
}