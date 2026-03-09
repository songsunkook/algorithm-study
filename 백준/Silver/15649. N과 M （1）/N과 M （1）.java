import java.io.*;
import java.util.*;

class Main {

    static int n, m;
    static int[] ch;
    static boolean[] vis;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ch = new int[m];
        vis = new boolean[n + 1];
        dfs(0);
        bw.write(sb + "");
        bw.close();
        br.close();
    }

    static void dfs(int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(ch[i] + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                vis[i] = true;
                ch[depth] = i;
                dfs(depth + 1);
                vis[i] = false;
            }
        }
    }
}