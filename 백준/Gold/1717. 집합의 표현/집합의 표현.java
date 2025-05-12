import java.io.*;
import java.util.*;

class Main {

    static int n, m;
    static int[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        p = new int[n + 1];
        for (int i = 0; i <= n; i++)
            p[i] = i;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int z = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (z == 0) {
                union(a, b);
            } else if (z == 1) {
                bw.write(find(a) == find(b) ? "YES\n" : "NO\n");
            }
        }

        bw.close();
        br.close();
    }

    static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        p[pa] = pb;
    }

    static int find(int a) {
        if (a != p[a])
            p[a] = find(p[a]);
        return p[a];
    }
}