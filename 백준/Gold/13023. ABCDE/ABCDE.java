import java.io.*;
import java.util.*;

class Main {
    static List<Integer>[] arr;
    static boolean[] vis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
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
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            vis[i] = true;
            if (dfs(i, 0)) {
                flag = true;
                break;
            }
            vis[i] = false;
        }
        bw.write(flag ? "1" : "0");
        bw.close();
        br.close();
    }

    static boolean dfs(int num, int depth) {
        if (depth >= 4) {
            return true;
        }
        for (int a : arr[num]) {
            if (!vis[a]) {
                vis[a] = true;
                if (dfs(a, depth + 1))
                    return true;
                vis[a] = false;
            }
        }
        return false;
    }
}