import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[][] wall;
    static boolean[][][] visited;
    static Queue<ThreePair> queue;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        wall = new boolean[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            for (int j = 0; j < M; j++) {
                wall[i][j] = input.charAt(j) == '1';
            }
        }

        if (N == 1 && M == 1) {
            bw.write("1");
        } else {
            bw.write(Integer.toString(bfs()));
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static int bfs() {
        int step = 1;
        queue = new LinkedList<>();
        queue.offer(new ThreePair(0, 0, 1));
        visited[0][0][1] = true;
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            step++;
            for (int i = 0; i < qSize; i++) {
                ThreePair curr = queue.poll();
                if (move(curr)) {
                    return step;
                }
            }
        }
        return -1;
    }

    static boolean move(ThreePair curr) {
        int[] cr = {-1, 0, 1, 0};
        int[] cc = {0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            int nr = curr.r + cr[i];
            int nc = curr.c + cc[i];
            if (nr == N - 1 && nc == M - 1) {
                return true;
            }
            if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
                continue;
            }
            if (visited[nr][nc][curr.skill]) {
                continue;
            }
            if (wall[nr][nc]) {
                if (curr.skill > 0) {
                    visited[nr][nc][0] = true;
                    queue.offer(new ThreePair(nr, nc, 0));
                }
            } else {
                visited[nr][nc][curr.skill] = true;
                queue.offer(new ThreePair(nr, nc, curr.skill));
            }
        }
        return false;
    }

    static class ThreePair {
        int r, c, skill;

        public ThreePair(int r, int c, int skill) {
            this.r = r;
            this.c = c;
            this.skill = skill;
        }
    }
}
