import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, H;
    static boolean[][][] visited;
    static int[][][] board;
    static Queue<threePairs> queue = new LinkedList<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        visited = new boolean[H][N][M];
        board = new int[H][N][M];

        boolean alreadyClear = true;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    board[i][j][k] = Integer.parseInt(st.nextToken());
                    if (alreadyClear) {
                        alreadyClear = false;
                    }
                    if (board[i][j][k] == 1 && !visited[i][j][k]) {
                        visited[i][j][k] = true;
                        queue.add(new threePairs(i, j, k));
                    }
                }
            }
        }
        if (alreadyClear) {
            bw.write("0");
            bw.flush();
            bw.close();
            br.close();
            return;
        }

        int day = -1;
        while (!queue.isEmpty()) {
            day++;
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                threePairs curr = queue.poll();

                tomato(curr.r - 1, curr.c, curr.h);
                tomato(curr.r, curr.c + 1, curr.h);
                tomato(curr.r + 1, curr.c, curr.h);
                tomato(curr.r, curr.c - 1, curr.h);
                tomato(curr.r, curr.c, curr.h - 1);
                tomato(curr.r, curr.c, curr.h + 1);
            }
        }

        boolean clear = true;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (board[i][j][k] == 0) {
                        clear = false;
                    }
                }
            }
        }

        if (clear) {
            bw.write(Integer.toString(day));
        } else {
            bw.write("-1");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void tomato(int r, int c, int h) {
        if (r >= 0 && c >= 0 && h >= 0 && r < N && c < M && h < H) {
            if (board[h][r][c] == 0 && !visited[h][r][c]) {
                visited[h][r][c] = true;
                board[h][r][c] = 1;
                queue.offer(new threePairs(h, r, c));
            }
        }
    }

    static class threePairs {
        int r, c, h;

        public threePairs(int i, int j, int k) {
            h = i;
            r = j;
            c = k;
        }
    }
}
