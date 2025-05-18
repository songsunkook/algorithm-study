import java.io.*;
import java.util.*;

class Main {
    static int n, m;
    static List<Dist>[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new List[n + 1];
        for (int i = 0; i <= n; i++)
            arr[i] = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            arr[a].add(new Dist(b, d));
            arr[b].add(new Dist(a, d));
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bw.write(find(a, b) + "\n");
        }

        bw.close();
        br.close();
    }

    static int find(int start, int end) {
        boolean[] v = new boolean[n + 1];
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(start, 0));
        v[start] = true;
        while(!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.node == end)
                return cur.total;
            
            for(Dist next : arr[cur.node]) {
                if (!v[next.node]) {
                    v[next.node] = true;
                    q.offer(new Node(next.node, cur.total + next.dist));
                }
            }
        }
        throw new RuntimeException();
    }

    static class Dist {
        int node;
        int dist;

        Dist(int nn, int dd) {
            node = nn;
            dist = dd;
        }
    }

    static class Node {
        int node;
        int total;

        Node(int n, int t) {
            node = n;
            total = t;
        }
    }
}