import java.io.*;
import java.util.*;

class Main {

    static int n;
    static int[] l, r;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        l = new int[n];
        r = new int[n];
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            l[a] = b;
            r[a] = c;
        }

        // DFS 하면서 전체 왕복 비용 계산
        // 가장 마지막 노드를 방문했을 때는 복귀 비용 계산
        // 리프노드 방문 시마다 lastLeaf를 갱신하면, 마지막 방문 리프 노드를 알 수 있다.
        // 반환값: 편도 비용.
        // 마지막 노드였으면 기존 합 + 편도 비용(not 왕복)

        int total = dfs(0);
        if (total == 1) {
            bw.write("0");
        } else {
            int cur = 0, dep = 0;
            while (r[cur] != -2) {
                cur = r[cur];
                dep++;
            }
            bw.write(total * 2 - dep + "");
        }
        bw.close();
        br.close();
    }

    static int dfs(int idx) {
        int ll = 0, rr = 0;
        if (l[idx] == -2 && r[idx] == -2) {
            return 0;
        }
        if (l[idx] != -2) {
            ll = dfs(l[idx]) + 1;
        }
        if (r[idx] != -2) {
            rr = dfs(r[idx]) + 1;
        }
        return ll + rr;
    }
}