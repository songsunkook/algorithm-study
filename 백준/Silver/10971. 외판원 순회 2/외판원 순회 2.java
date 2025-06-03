import java.io.*;
import java.util.*;

class Main {

    static int n;
    static long min = Long.MAX_VALUE;
    static int[][] w;
    static boolean[] vis;
    static List<Integer> path = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        w = new int[n][n];
        vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                w[i][j] = Integer.parseInt(st.nextToken());
        }

        vis[0] = true;
        dfs(0);

        bw.write(min + "");
        bw.close();
        br.close();
    }

    static void dfs(int cur) {
        path.add(cur);

        if (path.size() == n) {
            if (w[path.get(n - 1)][0] == 0)
                return;
            int result = 0;
            for (int i = 0; i < n - 1; i++) {
                result += w[path.get(i)][path.get(i + 1)];
            }
            result += w[path.get(n - 1)][0];
            min = Math.min(min, result);
        }

        for (int next = 0; next < n; next++) {
            if (!vis[next] && w[cur][next] != 0) {
                vis[next] = true;
                dfs(next);
                vis[next] = false;
            }
        }
        path.remove(Integer.valueOf(cur));
    }
}
