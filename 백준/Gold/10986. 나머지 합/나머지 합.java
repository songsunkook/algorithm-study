import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] sum = new long[N + 1];
        long[] c = new long[M];
        st = new StringTokenizer(br.readLine());
        long result = 0;
        for (int i = 1; i <= N; i++) {
            int in = Integer.parseInt(st.nextToken());
            sum[i] = (in % M + sum[i - 1]) % M;
            c[(int) sum[i]]++;
            if (sum[i] == 0)
                result++;
        }
        for (int i = 0; i < M; i++) {
            result += c[i] * (c[i] - 1) / 2;
        }
        bw.write(result + "");
        bw.close();
        br.close();
    }
}