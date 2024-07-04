import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[][] visited, miro;
    static List<List<Integer>> adj = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N][M];
        miro = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String input = st.nextToken();
            for (int j = 0; j < M; j++)
                miro[i][j] = input.charAt(j) == '1';
        }

        //문제 풀이
        Queue<Pair> queue = new LinkedList<>();
        int count = 0;
        boolean success = false;
        queue.offer(new Pair(0, 0));
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            if (success)
                break;
            count++;
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                Pair curr = queue.poll();
                if (curr.r == N - 1 && curr.c == M - 1) {
                    success = true;
                    break;
                }
                if (curr.r - 1 >= 0 && !visited[curr.r - 1][curr.c] && miro[curr.r - 1][curr.c]) {
                    visited[curr.r - 1][curr.c] = true;
                    queue.offer(new Pair(curr.r - 1, curr.c));
                }
                if (curr.r + 1 < N && !visited[curr.r + 1][curr.c] && miro[curr.r + 1][curr.c]) {
                    visited[curr.r + 1][curr.c] = true;
                    queue.offer(new Pair(curr.r + 1, curr.c));
                }
                if (curr.c - 1 >= 0 && !visited[curr.r][curr.c - 1] && miro[curr.r][curr.c - 1]) {
                    visited[curr.r][curr.c - 1] = true;
                    queue.offer(new Pair(curr.r, curr.c - 1));
                }
                if (curr.c + 1 < M && !visited[curr.r][curr.c + 1] && miro[curr.r][curr.c + 1]) {
                    visited[curr.r][curr.c + 1] = true;
                    queue.offer(new Pair(curr.r, curr.c + 1));
                }
            }
        }
        bw.write(Integer.toString(count));

        bw.flush();
        bw.close();
        br.close();
    }
}

class Pair {
    public int r, c;

    Pair(int r, int c) {
        this.r = r;
        this.c = c;
    }
}
