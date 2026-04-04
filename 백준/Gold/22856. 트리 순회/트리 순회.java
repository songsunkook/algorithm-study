import java.io.*;
import java.util.*;

/**
 * 전체 거리 * 2 - 루트부터 마지막 노드까지의 거리
 */
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] l = new int[n + 1];
        int[] r = new int[n + 1];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            l[a] = b;
            r[a] = c;
        }

        int cur = 1, dep = 0;
        while (r[cur] != -1) {
            cur = r[cur];
            dep++;
        }

        // 전체 거리 = n - 1
        bw.write((n - 1) * 2 - dep + "");
        bw.close();
        br.close();
    }
}