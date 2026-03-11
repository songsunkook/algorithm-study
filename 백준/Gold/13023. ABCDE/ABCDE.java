import java.io.*;
import java.util.*;

class Main {
    static int n, m;
    static List<Integer>[] arr;
    static boolean[] vis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new ArrayList[n];
        vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                vis[i] = true;
                if (dfs(i, 1)) {
                    bw.write("1");
                    bw.close();
                    br.close();
                    return;
                }
                vis[i] = false;
            }
        }
        bw.write("0");
        bw.close();
        br.close();
    }

    static boolean dfs(int s, int dep) {
        if (dep >= 5) {
            return true;
        }
        for (int fri : arr[s]) {
            if (!vis[fri]) {
                vis[fri] = true;
                if (dfs(fri, dep + 1)) {
                    return true;
                }
                vis[fri] = false;
            }
        }
        return false;
    }
}