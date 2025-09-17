import java.io.*;
import java.util.*;

class Main {
    static int[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        p = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            p[i] = i;
        }
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int a = Integer.parseInt(st.nextToken());
                if (a == 1)
                    union(i, j);
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int first = Integer.parseInt(st.nextToken());
        String result = "YES";
        for (int i = 1; i < m; i++) {
            int a = Integer.parseInt(st.nextToken());
            if (find(a) != find(first)) {
                result = "NO";
                break;
            }
        }
        bw.write(result);
        bw.close();
        br.close();
    }

    static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        p[pa] = pb;
    }

    static int find(int a) {
        if (p[a] != a)
            p[a] = find(p[a]);
        return p[a];
    }
}