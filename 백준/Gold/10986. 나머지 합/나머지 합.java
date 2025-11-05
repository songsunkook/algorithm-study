import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] S = new int[N + 1];
        long[] C = new long[M];
        long count = 0;
        for (int i = 1; i <= N; i++) {
            S[i] = (S[i - 1] + Integer.parseInt(st.nextToken())) % M;
            C[S[i]]++;
            if (S[i] == 0)
                count++;
        }

        for (int i = 0; i < M; i++) {
            count += C[i] * (C[i] - 1) / 2;
        }

        bw.write(count + "");
        bw.close();
        br.close();
    }
}