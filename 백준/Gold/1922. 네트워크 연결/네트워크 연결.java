import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] arr = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[a][b] = c;
            arr[b][a] = c;
        }

        PriorityQueue<P> q = new PriorityQueue<>((a, b) -> Integer.compare(a.d, b.d));
        q.offer(new P(1, 0));
        int sum = 0, count = 0;
        boolean[] vis = new boolean[n + 1];
        while (!q.isEmpty()) {
            P cur = q.poll();
            if (vis[cur.n])
                continue;
            count++;
            vis[cur.n] = true;
            sum += cur.d;
            if (count == n)
                break;
            for (int next = 1; next <= n; next++) {
                if (arr[cur.n][next] != 0 && !vis[next]) {
                    q.offer(new P(next, arr[cur.n][next]));
                }
            }
        }
        bw.write(sum + "");
        bw.close();
        br.close();
    }

    static class P {
        int n;
        int d;

        P(int nn, int dd) {
            n = nn;
            d = dd;
        }
    }
}