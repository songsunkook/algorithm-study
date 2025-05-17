import java.io.*;
import java.util.*;

class Main {
    static List<Integer>[] arr;
    static boolean[] live;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] p = new int[n];
        live = new boolean[n];
        arr = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new ArrayList<>();
            live[i] = true;
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            p[i] = Integer.parseInt(st.nextToken());
            if (p[i] != -1)
                arr[p[i]].add(i);
        }
        int target = Integer.parseInt(br.readLine());
        removeChilds(target);

        int leaf = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] != null) {
                arr[i].removeIf(child -> !live[child]);
                if (arr[i].isEmpty())
                    leaf++;
            }
        }
        bw.write(leaf + "");
        bw.close();
        br.close();
    }

    static void removeChilds(int cur) {
        for (var i : arr[cur])
            removeChilds(i);
        arr[cur].clear();
        arr[cur] = null;
        live[cur] = false;
    }
}