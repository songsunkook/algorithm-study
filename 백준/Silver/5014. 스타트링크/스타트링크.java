import java.io.*;
import java.util.*;

class Main {
    static int f, s, g, u, d;
    static boolean[] vis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        vis = new boolean[f + 1];

        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        vis[s] = true;
        int time = -1;
        while (!q.isEmpty()) {
            int qSize = q.size();
            time++;
            for (int i = 0; i < qSize; i++) {
                int cur = q.poll();
                if (cur == g) {
                    bw.write(time + "");
                    bw.close();
                    br.close();
                    return;
                }
                if (canGo(cur + u)) {
                    vis[cur + u] = true;
                    q.offer(cur + u);
                }
                if (canGo(cur - d)) {
                    vis[cur - d] = true;
                    q.offer(cur - d);
                }
            }
        }
        bw.write("use the stairs");
        bw.close();
        br.close();
    }

    static boolean canGo(int n) {
        return n > 0 && n <= f && !vis[n];
    }
}