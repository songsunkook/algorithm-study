import java.io.*;
import java.util.*;

class Main {

    static boolean[] vis;
    static List<Integer>[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        vis = new boolean[N];
        arr = new List[N];
        for (int i = 0; i < N; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            arr[a].add(b);
            arr[b].add(a);
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (!vis[i]) {
                vis[i] = true;
                dfs(i);
                cnt++;
            }
        }
        bw.write(cnt + "");
        bw.close();
        br.close();
    }

    static void dfs(int c) {
        for (int next : arr[c]) {
            if (!vis[next]) {
                vis[next] = true;
                dfs(next);
            }
        }
    }
}