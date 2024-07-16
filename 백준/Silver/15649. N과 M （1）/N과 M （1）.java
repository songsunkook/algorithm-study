import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] data;
    static boolean[] visited;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        data = new int[M];
        visited = new boolean[N];

        dfs(0);

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int depth) throws IOException {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                bw.write(Integer.toString(data[i]) + ' ');
            }
            bw.write('\n');
            return;
        }

        for(int i=0;i<N;i++) {
            if(!visited[i]) {
                visited[i] = true;
                data[depth] = i + 1;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}
