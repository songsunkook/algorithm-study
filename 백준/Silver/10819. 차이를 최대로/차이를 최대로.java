import java.io.*;
import java.util.*;

class Main {
    static int n;
    static long max;
    static int[] arr, path;
    static boolean[] vis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        vis = new boolean[n];
        path = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        find(0);
        bw.write(max + "");
        bw.close();
        br.close();
    }

    static void find(int depth) {
        if (depth == n) {
            long sum = 0;
            for (int i = 0; i < n - 1; i++) {
                sum += Math.abs(path[i] - path[i + 1]);
            }
            max = Math.max(max, sum);
        }

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                vis[i] = true;
                path[depth] = arr[i];
                find(depth + 1);
                vis[i] = false;
            }
        }
    }
}