import java.io.*;
import java.util.*;

class Main {
    static int n, m, s;
    static boolean[] vis;
    static List<Integer>[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken()) - 1;
        arr = new ArrayList[n];
        vis = new boolean[n];
        vis[s] = true;
        for (int i = 0; i < n; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            arr[a].add(b);
            arr[b].add(a);
        }
        for (int i = 0; i < n; i++) {
            Collections.sort(arr[i]);
        }
        dfs(s);
        sb.append("\n");
        vis = new boolean[n];
        vis[s] = true;
        bfs(s);
        bw.write(sb + "");
        bw.close();
        br.close();
    }

    static void dfs(int start) {
        sb.append(start + 1 + " ");
        for (int next : arr[start]) {
            if (!vis[next]) {
                vis[next] = true;
                dfs(next);
            }
        }
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        while (!q.isEmpty()) {
            int cur = q.poll();
            sb.append(cur + 1 + " ");
            for (int next : arr[cur]) {
                if (!vis[next]) {
                    vis[next] = true;
                    q.offer(next);
                }
            }
        }
    }
}