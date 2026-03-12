import java.io.*;
import java.util.*;

/**
 * 가로, 세로, 대각선을 유일하게 식별해야 한다.
 * 가로: 한줄씩 내려가며 진행
 * 세로: boolean[col]
 * / 대각선: boolean[i + j]
 * \ 대각선: boolean[i - j + n - 1] (음수 인덱스 방지)
 */
class Main {
    static int n;
    static boolean[] dia1, dia2, col;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        dia1 = new boolean[2 * n];
        dia2 = new boolean[2 * n];
        col = new boolean[n];
        bw.write(dfs(0) + "");
        bw.close();
        br.close();
    }

    static int dfs(int row) {
        if (row == n) {
            return 1;
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (can(row, i)) {
                put(row, i, true);
                cnt += dfs(row + 1);
                put(row, i, false);
            }
        }
        return cnt;
    }

    static boolean can(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < n
                && !col[c] && !dia1[r + c] && !dia2[r - c + n - 1];
    }

    static void put(int r, int c, boolean flag) {
        col[c] = flag;
        dia1[r + c] = flag;
        dia2[r - c + n - 1] = flag;
    }
}