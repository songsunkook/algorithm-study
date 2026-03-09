import java.io.*;
import java.util.*;

/**
 * 색종이 크기: 1x1 ~ 5x5
 * 색종이 최소 개수를 구해야 한다. -> 큰 색종이부터 붙여보고 안되면 하나씩 사이즈를 줄인다.
 * 하지만 오히려 작은 색종이를 붙이고 넘어가야 나중에 더 큰 색종이를 붙일 수도 있으니, 모든 사이즈를 붙여봐야 한다.
 */
class Main {

    static boolean[][] board = new boolean[10][10];
    static int[] paper = { 0, 5, 5, 5, 5, 5 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int r = 0; r < 10; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < 10; c++) {
                board[r][c] = Integer.parseInt(st.nextToken()) == 1;
            }
        }
        int ans = dfs(0, 0);
        bw.write(ans == 99999999 ? "-1" : (ans + ""));
        bw.close();
        br.close();
    }

    static int dfs(int sr, int sc) {
        for (int r = sr; r < 10; r++) {
            for (int c = 0; c < 10; c++) {
                if (board[r][c]) {
                    int min = 99999999;
                    for (int s = 1; s <= 5; s++) {
                        if (can(r, c, s)) {
                            paste(r, c, s, false);
                            min = Math.min(min, dfs(r, c) + 1);
                            paste(r, c, s, true);
                        }
                    }
                    return min;
                }
            }
        }
        return 0;
    }

    static boolean can(int R, int C, int s) {
        if (paper[s] <= 0) {
            return false;
        }
        if (R + s > 10 || C + s > 10) {
            return false;
        }
        for (int r = R; r < R + s; r++) {
            for (int c = C; c < C + s; c++) {
                if (!board[r][c]) {
                    return false;
                }
            }
        }
        return true;
    }

    static void paste(int R, int C, int s, boolean flag) {
        if (flag) {
            paper[s]++;
        } else {
            paper[s]--;
        }
        for (int r = R; r < R + s; r++) {
            for (int c = C; c < C + s; c++) {
                board[r][c] = flag;
            }
        }
    }
}