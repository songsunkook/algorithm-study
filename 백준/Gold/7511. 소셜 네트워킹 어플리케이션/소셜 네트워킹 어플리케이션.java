import java.io.*;
import java.util.*;

class Main {

    static int[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            bw.write("Scenario " + t + ":\n");
            int n = Integer.parseInt(br.readLine());
            int k = Integer.parseInt(br.readLine());
            p = new int[n];
            for (int i = 0; i < n; i++)
                p[i] = i;
            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a, b);
            }

            int m = Integer.parseInt(br.readLine());
            for (int i = 0; i < m; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                bw.write(find(u) == find(v) ? "1\n" : "0\n");
            }
            bw.write("\n");
        }

        bw.close();
        br.close();
    }

    static void union(int a, int b) {
        int pa = find(a);
        int pb= find(b);
        p[pa] = pb;
    }

    static int find(int a) {
        if (a != p[a])
            p[a] = find(p[a]);
        return p[a];
    }
}