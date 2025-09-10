import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[][] arr = new boolean[n][n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            arr[a][b] = true;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][k] && arr[k][j]) {
                        arr[i][j] = true;
                    }
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            boolean can = true;
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;
                if (!arr[i][j] && !arr[j][i]) {
                    can = false;
                    break;
                }
            }
            if (can)
                cnt++;
        }
        bw.write(cnt + "");
        bw.close();
        br.close();
    }
}