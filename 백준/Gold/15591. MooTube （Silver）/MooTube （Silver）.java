import java.io.*;
import java.util.*;

class Main {
    static int n, q;
    static List<N>[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        arr = new List[n + 1];
        for (int i = 1; i < n + 1; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            arr[a].add(new N(b, r));
            arr[b].add(new N(a, r));
        }

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int idx = Integer.parseInt(st.nextToken());

            bw.write(count(idx, weight) + "\n");
        }

        bw.close();
        br.close();
    }

    static int count(int start, int weight) {
        boolean[] vis = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        vis[start] = true;
        q.add(start);
        int cnt = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (N next : arr[cur]) {
                if (!vis[next.a] && next.r >= weight) {
                    cnt++;
                    vis[next.a] = true;
                    q.offer(next.a);
                }
            }
        }
        return cnt;
    }

    static class N {
        int a;
        int r;

        N(int aa, int rr) {
            a = aa;
            r = rr;
        }
    }
}