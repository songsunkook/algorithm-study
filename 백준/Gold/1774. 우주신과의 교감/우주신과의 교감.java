import java.io.*;
import java.util.*;

class Main {
    static double INF = 1000000000;
    static P[] arr;
    static int[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new P[n + 1];
        p = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i] = new P(x, y);
            p[i] = i;
        }
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }
        List<E> edges = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                edges.add(new E(i, j, dis(arr[i], arr[j])));
            }
        }
        Collections.sort(edges, (a, b) -> Double.compare(a.d, b.d));

        double sum = 0;
        for (var edge : edges) {
            if (find(edge.s) == find(edge.e))
                continue;
            union(edge.s, edge.e);
            sum += edge.d;
        }
        bw.write(String.format("%.2f", sum));
        bw.close();
        br.close();
    }

    static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa != pb) {
            if (pa < pb) {
                p[pb] = pa;
            } else {
                p[pa] = pb;
            }
        }
    }

    static int find(int a) {
        if (p[a] != a)
            p[a] = find(p[a]);
        return p[a];
    }

    static double dis(P a, P b) {
        long ax = a.x;
        long ay = a.y;
        long bx = b.x;
        long by = b.y;
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