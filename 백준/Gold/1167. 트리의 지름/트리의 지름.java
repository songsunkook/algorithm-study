import java.io.*;
import java.util.*;

class Main {

    static int v, dia, dep, depN;
    static List<N>[] arr;
    static boolean[] vis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        v = Integer.parseInt(br.readLine());
        arr = new List[v];
        vis = new boolean[v];
        for (int i = 0; i < v; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < v; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            while (true) {
                int b = Integer.parseInt(st.nextToken()) - 1;
                if (b == -2) {
                    break;
                }
                int c = Integer.parseInt(st.nextToken());
                arr[a].add(new N(b, c));
                arr[b].add(new N(a, c));
            }
        }

        vis[0] = true;
        dep = -1;
        depN = -1;
        dfs(0, 0);
        Arrays.fill(vis, false);
        vis[depN] = true;
        dep = -1;
        int aa = depN;
        depN = -1;
        dfs(aa, 0);
        bw.write(dep + "");
        bw.close();
        br.close();
    }

    static void dfs(int now, int nowD) {
        if (dep < nowD) {
            dep = nowD;
            depN = now;
        }
        for (N next : arr[now]) {
            if (!vis[next.n]) {
                vis[next.n] = true;
                dfs(next.n, nowD + next.d);
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