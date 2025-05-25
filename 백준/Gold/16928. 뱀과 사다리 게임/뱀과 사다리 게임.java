import java.io.*;
import java.util.*;

class Main {
    static int n, m;
    static int[] vis;
    static List<N> snake, ladder;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        snake = new ArrayList<>();
        ladder = new ArrayList<>();
        vis = new int[101];
        Arrays.fill(vis, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            ladder.add(new N(a, b));
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            snake.add(new N(a, b));
        }

        Queue<P> q = new LinkedList<>();
        q.offer(new P(1, 0));
        vis[1] = 0;
        int result = 0;
        while (!q.isEmpty()) {
            P cur = q.poll();
            if (cur.n == 100) {
                result = cur.d;
            }
            for (int i = 1; i <= 6; i++) {
                P next = new P(cur.n + i, cur.d + 1);

                boolean went = false;
                for (var a : snake)
                    if (next.n == a.s)
                        next = new P(a.e, next.d);
                for (var a : ladder)
                    if (next.n == a.s)
                        next = new P(a.e, next.d);

                if (vis[next.n] > cur.d + 1) {
                    q.offer(new P(next.n, cur.d + 1));
                    vis[next.n] = cur.d + 1;
                }
            }
        }
        bw.write(result + "");
        bw.close();
        br.close();
    }

    static class P {
        int n;
        int d;

        P(int nn, int dd) {
            n = nn;
            d = dd;
            if (n >= 101)
                n -= 100;
        }
    }

    static class N {
        int s;
        int e;

        N(int ss, int ee) {
            s = ss;
            e = ee;
        }
    }
}