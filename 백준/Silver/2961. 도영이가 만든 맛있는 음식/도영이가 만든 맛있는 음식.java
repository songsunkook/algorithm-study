import java.io.*;
import java.util.*;

class Main {
    static int n, a, b;
    static long min = Long.MAX_VALUE;
    static int[] arra, arrb;
    static boolean[] vis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arra = new int[n];
        arrb = new int[n];
        vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arra[i] = Integer.parseInt(st.nextToken());
            arrb[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            func(i, 1, 0);
        }
        bw.write(min + "");
        bw.close();
        br.close();
    }

    static void func(int cur, long sumA, long sumB) {
        sumA *= arra[cur];
        sumB += arrb[cur];
        if (Math.abs(sumA - sumB) < min) {
            min = Math.abs(sumA - sumB);
        }
        vis[cur] = true;
        for (int i = cur + 1; i < n; i++) {
            if (!vis[i]) {
                func(i, sumA, sumB);
            }
        }
        vis[cur] = false;
        sumA /= arra[cur];
        sumB -= arrb[cur];
    }
}