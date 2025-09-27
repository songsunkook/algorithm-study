import java.io.*;
import java.util.*;

class Main {
    static double INF = 1000000000;
    static P[] arr;
    static boolean[] vis;
    static boolean[][] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new P[n + 1];
        vis = new boolean[n + 1];
        adj = new boolean[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i] = new P(x, y);
        }
        PriorityQueue<E> q = new PriorityQueue<>((a, b) -> Double.compare(a.d, b.d));
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a][b] = true;
            adj[b][a] = true;
        }
        double sum = 0;
        for (int i = 2; i <= n; i++) {
            q.offer(new E(1, i, dis(1, i)));
        }
        vis[1] = true;
        while (!q.isEmpty()) {
            var cur = q.poll();
            if (vis[cur.e]) {
                continue;
            }
            vis[cur.e] = true;
            sum += cur.d;
            for (int i = 1; i <= n; i++) {
                if (i == cur.s || vis[i])
                    continue;
                q.offer(new E(cur.e, i, dis(cur.e, i)));
            }
        }
        bw.write(String.format("%.2f", sum));
        bw.close();
        br.close();
    }

    static double dis(int a, int b) {
        if (adj[a][b])
            return 0;
        long ax = arr[a].x;
        long ay = arr[a].y;
        long bx = arr[b].x;
        long by = arr[b].y;
        return Math.sqrt((ax - bx) * (ax - bx) + (ay - by) * (ay - by));
    }

    static class P {
        int x;
        int y;

        P(int xx, int yy) {
            x = xx;
            y = yy;
        }
    }

    static class E {
        int s;
        int e;
        double d;

        E(int ss, int ee, double dd) {
            s = ss;
            e = ee;
            d = dd;
        }
    }
}