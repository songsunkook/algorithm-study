import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken()) - 1;
            List<E>[] adj = new List[V];
            for (int i = 0; i < V; i++) {
                adj[i] = new ArrayList<>();
            }
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;
                int c = Integer.parseInt(st.nextToken());
                adj[b].add(new E(a, c));
            }

            int[] dist = new int[V];
            Arrays.fill(dist, Integer.MAX_VALUE);
            // dist[S] = 0;
            PriorityQueue<E> pq = new PriorityQueue<E>((a, b) -> Integer.compare(a.d, b.d));
            pq.offer(new E(S, 0));
            while (!pq.isEmpty()) {
                E cur = pq.poll();
                for (var e : adj[cur.n]) {
                    int nextN = e.n;
                    int nextD = cur.d + e.d;
                    if (dist[nextN] > nextD) {
                        pq.offer(new E(nextN, nextD));
                        dist[nextN] = nextD;
                    }
                }
            }

            int cnt = 0;
            int max = 0;
            for (int i = 0; i < V; i++) {
                if (dist[i] != Integer.MAX_VALUE && i != S) {
                    max = Math.max(max, dist[i]);
                    cnt++;
                }
            }
            bw.write(cnt + 1 + " " + max + "\n");
        }

        bw.close();
        br.close();
    }

    static class E {
        int n;
        int d;

        E(int nn, int dd) {
            n = nn;
            d = dd;
        }
    }
}