import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[] vis = new boolean[200001];
        Deque<N> q = new LinkedList<>();
        q.addLast(new N(n, 0));
        vis[n] = true;
        int result = 0;
        while (!q.isEmpty()) {
            N cur = q.removeFirst();
            if (cur.n == k) {
                result = cur.dist;
                break;
            }
            for (int[] next : drc(cur.n)) {
                if (next[0] >= 0 && next[0] <= 200000 && !vis[next[0]]) {
                    if (next[1] == 0)
                        q.addFirst(new N(next[0], cur.dist + next[1]));
                    else 
                        q.addLast(new N(next[0], cur.dist + next[1]));
                    vis[next[0]] = true;
                }
            }
        }
        bw.write(result + "");
        bw.close();
        br.close();
    }

    static int[][] drc(int n) {
        return new int[][] {{ n * 2, 0 }, { n - 1, 1 }, { n + 1, 1 } };
    }

    static class N {
        int n;
        int dist;

        N(int nn, int dd) {
            n = nn;
            dist = dd;
        }
    }
}