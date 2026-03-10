import java.io.*;
import java.util.*;

class Main {
    static int V;
    static List<N>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        V = Integer.parseInt(br.readLine());
        adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            while (true) {
                int o = Integer.parseInt(st.nextToken());
                if (o == -1)
                    break;
                int d = Integer.parseInt(st.nextToken());
                adj[v - 1].add(new N(o - 1, d));
                adj[o - 1].add(new N(v - 1, d));
            }
        }
        Line node1 = bfs(0);
        Line node2 = bfs(node1.n);
        bw.write(node2.total + "");
        bw.close();
        br.close();
    }

    static Line bfs(int start) {
        boolean[] vis = new boolean[V];
        Queue<Line> q = new LinkedList<>();
        q.offer(new Line(start, 0));
        vis[start] = true;
        Line max = new Line(-1, -1);
        while (!q.isEmpty()) {
            Line cur = q.poll();
            if (cur.total > max.total) {
                max = cur;
            }
            for (N o : adj[cur.n]) {
                if (!vis[o.n]) {
                    vis[o.n] = true;
                    q.offer(new Line(o.n, cur.total + o.d));
                }
            }
        }

        return max;
    }

    static class N {
        int n;
        int d;

        N(int nn, int dd) {
            n = nn;
            d = dd;
        }
    }

    static class Line {
        int n;
        int total;

        Line(int nn, int tt) {
            n = nn;
            total = tt;
        }
    }
}