import java.io.*;
import java.util.*;

class Main {
    static int n;
    static List<Integer>[] arr;
    static int min = Integer.MAX_VALUE;
    static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        // arr = new int[n + 1];
        arr = new List[n + 1];
        count = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == -1 && b == -1)
                break;
            arr[a].add(b);
            arr[b].add(a);
        }

        int minCount = 0;
        for (int i = 1; i <= n; i++) {
            count[i] = depth(i);
            if (min > count[i]) {
                min = count[i];
                minCount = 0;
            }
            if (min == count[i]) {
                minCount++;
            }
        }

        bw.write(min + " " + minCount + "\n");
        for (int i = 1; i <= n; i++) {
            if (count[i] == min)
                bw.write(i + " ");
        }

        bw.close();
        br.close();
    }

    static int depth(int s) {
        boolean[] vis = new boolean[n + 1];
        vis[s] = true;
        Queue<N> q = new LinkedList<>();
        q.offer(new N(s, 0));
        N cur = null;
        while (!q.isEmpty()) {
            cur = q.poll();

            for (int next : arr[cur.n]) {
                if (!vis[next]) {
                    q.offer(new N(next, cur.d + 1));
                    vis[next] = true;
                }
            }
        }
        return cur.d;
    }

    static class N {
        int n;
        int d;

        N(int nn, int dd) {
            n = nn;
            d = dd;
        }
    }
}