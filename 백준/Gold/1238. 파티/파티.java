import java.io.*;
import java.util.*;

public class Main {
    static int N, M, X;
    static List<List<Pair>> adj = new ArrayList<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken()) - 1;

        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());
            adj.get(a).add(new Pair(b, c));
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, dijkstra(i, X) + dijkstra(X, i));
        }

        bw.write(Integer.toString(max) + '\n');

        bw.flush();
        bw.close();
        br.close();
    }

    private static int dijkstra(int start, int end) {
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        boolean[] visited = new boolean[N];
        //dist[v], v
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>();
        dist[start] = 0;
        priorityQueue.add(new Pair(start, 0));
        while (!priorityQueue.isEmpty()) {
            Pair curr = priorityQueue.poll();
            if (visited[curr.node]) {
                continue;
            }
            visited[curr.node] = true;
            for (Pair next : adj.get(curr.node)) {
                if (dist[next.node] > dist[curr.node] + next.cost) {
                    dist[next.node] = dist[curr.node] + next.cost;
                    priorityQueue.add(new Pair(next.node, dist[next.node]));
                }
            }
        }
        if (dist[end] == Integer.MAX_VALUE) {
            return -1;
        }
        return dist[end];
    }

    static class Pair implements Comparable<Pair> {
        int node, cost;

        Pair(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair o) {
            return cost - o.cost;
        }
    }
}
