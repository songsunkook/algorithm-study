import java.io.*;
import java.util.*;

class Main {

    static int n, m;
    static boolean[] vis;
    static List<Integer>[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new List[n];
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

        boolean result = false;
        for (int i = 0; i < n; i++) {
            vis = new boolean[n];
            if (dfs(i, 0)) {
                result = true;
                break;
            }
        }

        bw.write(result ? "1" : "0");
        bw.close();
        br.close();
    }

    static boolean dfs(int cur, int depth) {
        if (depth >= 4)
            return true;
        vis[cur] = true;
        int max = 0;
        for (int fri : arr[cur]) {
            if (vis[fri])
                continue;
            if (dfs(fri, depth + 1))
                return true;
        }
        vis[cur] = false;
        return false;
    }
}