import java.io.*;
import java.util.*;

class Main {
    static int n, k;
    static int[][] arr;
    // static boolean[][] vis;

    static int[][] dd = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n + 1][n + 1];
        // vis = new boolean[n + 1][n + 1];
        List<N> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] != 0) {
                    list.add(new N(i, j, 0));
                    // vis[i][j] = true;
                }
            }
        }
        Collections.sort(list, (a, b) -> Integer.compare(arr[a.r][a.c], arr[b.r][b.c]));
        // System.out.println(list);

        Queue<N> q = new LinkedList<>(list);

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        while (!q.isEmpty()) {
            N cur = q.poll();
            if (cur.d == s) {
                break;
            }
            for (int i = 0; i < 4; i++) {
                N next = new N(cur.r + dd[i][0], cur.c + dd[i][1], cur.d + 1);
                if (next.isIn() && /* !vis[next.r][next.c] && */ arr[next.r][next.c] == 0) {
                    // vis[next.r][next.c] = true;
                    arr[next.r][next.c] = arr[cur.r][cur.c];
                    q.offer(next);
                }
            }
        }
        // for (int i = 1; i <= n; i++) {
        //     for (int j = 1; j <= n; j++) {
        //         System.out.print(arr[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        bw.write(arr[x][y] + "");
        bw.close();
        br.close();
    }

    static class N {
        int r;
        int c;
        int d;

        N(int rr, int cc, int dd) {
            r = rr;
            c = cc;
            d = dd;
        }

        boolean isIn() {
            return r >= 1 && c >= 1 && r <= n && c <= n;
        }

        public String toString() {
            return "{" + r + c + d + ", " + arr[r][c] + "}";
        }
    }
}