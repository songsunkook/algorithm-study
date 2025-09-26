import java.io.*;
import java.util.*;

class Main {
    static int INF = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];
        List<E>[] adj = new List[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj[a].add(new E(b, c));
            adj[b].add(new E(a, c));
        }

        int max = 0;
        for (int s = 1; s <= n; s++) {
            int sum = 0;
            int[] dist = new int[n + 1];
            Arrays.fill(dist, INF);
            dist[s] = 0;
            PriorityQueue<E> q = new PriorityQueue<>((a, b) -> Integer.compare(a.w, b.w));
            q.offer(new E(s, 0));
            while (!q.isEmpty()) {
                var cur = q.poll();
                if (dist[cur.n] < cur.w)
                    continue;
                dist[cur.n] = cur.w;
                for (var next : adj[cur.n]) {
                    if (dist[next.n] > cur.w + next.w && cur.w + next.w <= m) {
                        q.offer(new E(next.n, cur.w + next.w));
                    }
                }
            }
            for (int i = 1; i <= n; i++) {
                if (dist[i] <= m)
                    sum += arr[i];
            }
            max = Math.max(max, sum);
        }
        bw.write(max + "");
        bw.close();
        br.close();
    }

    static class E {
        int n;
        int w;

        E(int nn, int ww) {
            n = nn;
            w = ww;
        }
    }
}