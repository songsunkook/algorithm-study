import java.io.*;
import java.util.*;

class Main {
    static int n, k;
    static boolean[][] arr, vis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new boolean[2][200100];
        vis = new boolean[2][200100];
        String line = br.readLine();
        int ci = 1;
        Arrays.fill(arr[0], true);
        Arrays.fill(arr[1], true);
        for (char c : line.toCharArray()) {
            arr[0][ci] = c == '1' ? true : false;
            ci++;
        }
        ci = 1;
        line = br.readLine();
        for (char c : line.toCharArray()) {
            arr[1][ci] = c == '1' ? true : false;
            ci++;
        }

        Queue<N> q = new LinkedList<>();
        q.offer(new N(0, 1, 0));
        vis[0][1] = true;
        boolean result = false;
        while (!q.isEmpty()) {
            N cur = q.poll();
            for (N next : getNext(cur)) {
                if (next.n >= 1
                        && !vis[next.l][next.n]
                        && arr[next.l][next.n]
                        && next.n > next.d) {

                    if (next.n > n + 1) {
                        result = true;
                        break;
                    }
                    vis[next.l][next.n] = true;
                    q.offer(next);
                }
            }
        }
        bw.write(result ? "1" : "0");
        bw.close();
        br.close();
    }

    static N[] getNext(N node) {
        int another = node.l == 1 ? 0 : 1;
        return new N[] {
                new N(node.l, node.n - 1, node.d + 1),
                new N(node.l, node.n + 1, node.d + 1),
                new N(another, node.n + k, node.d + 1)
        };
    }

    static class N {
        int l;
        int n;
        int d;

        N(int ll, int nn, int dd) {
            l = ll;
            n = nn;
            d = dd;
        }
    }
}