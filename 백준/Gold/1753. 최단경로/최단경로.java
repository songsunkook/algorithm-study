import java.io.*;
import java.util.*;

class Main {

    static int v, e, s;
    static List<N>[] adj;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(br.readLine());
        adj = new List[v + 1];
        dist = new int[v + 1];
        for (int i = 1; i <= v; i++) {
            adj[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }
        dist[s] = 0;
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj[a].add(new N(b, c));
        }

        PriorityQueue<N> q = new PriorityQueue<>((a, b) -> Integer.compare(a.d, b.d));
        q.offer(new N(s, 0));
        while (!q.isEmpty()) {
            N cur = q.poll();
            if (cur.d > dist[cur.n])
                continue;
            for (var a : adj[cur.n]) {
                int next = a.n;
                int weight = cur.d + a.d;
                if (weight < dist[next]) {
                    q.offer(new N(next, weight));
                    dist[next] = weight;
                }
            }
        }
        for (int i = 1; i <= v; i++) {
            bw.write(dist[i] == Integer.MAX_VALUE ? "INF\n" : dist[i] + "\n");
        }
        bw.close();
        br.close();
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