import java.io.*;
import java.util.*;

class Main {

    static int v, e;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        v = Integer.parseInt(br.readLine());
        e = Integer.parseInt(br.readLine());
        dist = new int[v + 1][v + 1];
        for (int i = 1; i <= v; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
        }
        for (int i = 0; i < e; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            dist[a][b] = Math.min(dist[a][b], c);
        }
        for (int k = 1; k <= v; k++) {
            for (int i = 1; i <= v; i++) {
                for (int j = 1; j <= v; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE)
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        for (int i = 1; i <= v; i++) {
            for (int j = 1; j <= v; j++) {
                bw.write(dist[i][j] == Integer.MAX_VALUE ? "0 " : dist[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.close();
        br.close();
    }
}