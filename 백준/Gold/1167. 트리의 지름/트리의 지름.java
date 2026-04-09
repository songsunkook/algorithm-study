import java.io.*;
import java.util.*;

class Main {

    static int n, maxNode = 0, maxLen = 0;
    static boolean[] vis;
    static List<N>[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr = new ArrayList[n + 1];
        vis = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            while (true) {
                int b = Integer.parseInt(st.nextToken());
                if (b == -1) {
                    break;
                }
                int c = Integer.parseInt(st.nextToken());
                arr[a].add(new N(b, c));
            }
        }

        vis[1] = true;
        dfs(1, 0);
        Arrays.fill(vis, false);
        vis[maxNode] = true;
        dfs(maxNode, 0);

        bw.write(maxLen + "");
        bw.close();
        br.close();
    }

    static void dfs(int node, int dep) {
        if (maxLen < dep) {
            maxNode = node;
            maxLen = dep;
        }

        for (N adj : arr[node]) {
            if (!vis[adj.n]) {
                vis[adj.n] = true;
                dfs(adj.n, dep + adj.d);
            }
        }
    }

    static class N {
        int n;
        int d;

        N(int nn, int dd) {
            n = nn;
            d = dd;
        }
    }
}