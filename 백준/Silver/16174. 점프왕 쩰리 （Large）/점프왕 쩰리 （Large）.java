import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int[][] arr;
    static boolean[][] can;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        can = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        Queue<P> q = new LinkedList<>();
        q.offer(new P(0, 0));
        can[0][0] = true;
        while (!q.isEmpty()) {
            P cur = q.poll();

            int moveAmount = arr[cur.r][cur.c];
            P next = new P(cur.r + moveAmount, cur.c);
            if (next.isIn() && !can[next.r][next.c]) {
                can[next.r][next.c] = true;
                q.offer(next);
            }

            next = new P(cur.r, cur.c + moveAmount);
            if (next.isIn() && !can[next.r][next.c]) {
                can[next.r][next.c] = true;
                q.offer(next);
            }
        }

        bw.write(can[n - 1][n - 1] ? "HaruHaru" : "Hing");
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

        boolean isIn() {
            return r >= 0 && c >= 0 && r < n && c < n;
        }
    }
}