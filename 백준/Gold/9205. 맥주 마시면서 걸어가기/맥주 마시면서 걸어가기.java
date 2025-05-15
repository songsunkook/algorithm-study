import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            P[] arr = new P[n + 2];
            boolean[] vis = new boolean[n + 2];
            for (int i = 0; i < n + 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                arr[i] = new P(r, c);
            }

            Queue<P> q = new LinkedList<>();
            q.offer(arr[0]);
            vis[0] = true;
            while (!q.isEmpty()) {
                P cur = q.poll();

                for (int i = 1; i < n + 2; i++) {
                    if (cur.distance(arr[i]) <= 1000 && !vis[i]) {
                        q.offer(arr[i]);
                        vis[i] = true;
                    }
                }
            }

            bw.write(vis[n + 1] ? "happy\n" : "sad\n");
        }

        bw.close();
        br.close();
    }

    static class P {
        int r;
        int c;

        P(int rr, int cc) {
            r = rr;
            c = cc;
        }

        int distance(P o) {
            return Math.abs(r - o.r) + Math.abs(c - o.c);
        }
    }
}