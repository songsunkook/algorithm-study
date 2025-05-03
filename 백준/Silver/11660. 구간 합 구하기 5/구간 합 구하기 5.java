import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 보드 입력
        int[][] arr = new int[n + 1][n + 1];
        for (int r = 1; r <= n; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 1; c <= n; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        // 누적합 계산 및 저장
        int[][] sum = new int[n + 1][n + 1];
        for (int r = 1; r <= n; r++) {
            for (int c = 1; c <= n; c++) {
                sum[r][c] = sum[r - 1][c] + sum[r][c - 1] - sum[r - 1][c - 1] + arr[r][c];
            }
        }

        // 문제 풀이
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            int result = sum[r2][c2] - sum[r2][c1 - 1] - sum[r1 - 1][c2] + sum[r1 - 1][c1 - 1];

            bw.write(result + "\n");
        }

        bw.close();
        br.close();
    }
}