import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int result = 0;
        boolean[] vis = new boolean[e + 1];
        Queue<Num> q = new LinkedList<>();
        q.offer(new Num(s, 0));
        while (!q.isEmpty()) {
            Num cur = q.poll();

            Num next = new Num(cur.n + 1, cur.d + 1);
            if (next.n == e) {
                result = next.d;
                break;
            }
            if (next.n <= e && !vis[next.n]) {
                q.offer(next);
                vis[next.n] = true;
            }

            next = new Num(cur.n * 2, cur.d + 1);
            if (next.n == e) {
                result = next.d;
                break;
            }
            if (next.n <= e && !vis[next.n]) {
                q.offer(next);
                vis[next.n] = true;
            }
        }

        bw.write(result + "");

        bw.close();
        br.close();
    }

    static class Num {
        int n;
        int d;

        Num(int nn, int dd) {
            n = nn;
            d = dd;
        }
    }
}