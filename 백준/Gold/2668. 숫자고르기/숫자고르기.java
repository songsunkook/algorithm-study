import java.io.*;
import java.util.*;

class Main {

    static int n;
    static int[] arr;
    static boolean[] vis, fin;
    static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        for (int i = 1; i <= n; i++)
            arr[i] = Integer.parseInt(br.readLine());

        vis = new boolean[n + 1];
        fin = new boolean[n + 1];
        for (int i = 1; i <= n; i++)
            if (!vis[i])
                dfs(i);

        Collections.sort(answer);
        bw.write(answer.size() + "\n");
        for (var r : answer)
            bw.write(r + "\n");
        bw.close();
        br.close();
    }

    static void dfs(int cur) {
        vis[cur] = true;
        int next = arr[cur];

        if (!vis[next]) {
            dfs(next);
        } else if (!fin[next]) {
            // cycle
            int tmp = next;
            answer.add(tmp);
            while (tmp != cur) {
                tmp = arr[tmp];
                answer.add(tmp);
            }
        }
        fin[cur] = true;
    }
}
