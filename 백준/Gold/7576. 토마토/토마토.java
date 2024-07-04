import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static boolean[][] visited;
    static int[][] board;
    static Queue<Pair> queue = new LinkedList<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        visited = new boolean[N][M];
        board = new int[N][M];

        boolean alreadyClear = true;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (alreadyClear) {
                    alreadyClear = false;
                }
                if (board[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    queue.add(new Pair(i, j));
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
                Pair curr = queue.poll();

                tomato(curr.r - 1, curr.c);
                tomato(curr.r, curr.c + 1);
                tomato(curr.r + 1, curr.c);
                tomato(curr.r, curr.c - 1);

            }
        }

        boolean clear = true;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 0) {
                    clear = false;
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

    static void tomato(int r, int c) {
        if (r >= 0 && c >= 0 && r < N && c < M) {
            if (board[r][c] == 0 && !visited[r][c]) {
                visited[r][c] = true;
                board[r][c] = 1;
                queue.offer(new Pair(r, c));
            }
        }
    }

    static class Pair {
        int r, c;

        public Pair(int i, int j) {
            r = i;
            c = j;
        }
    }
}
