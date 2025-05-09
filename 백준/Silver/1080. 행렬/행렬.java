import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        boolean[][] before = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            String input = br.readLine();
            int j = 0;
            for (var ch : input.toCharArray()) {
                before[i][j++] = ch == '1';
            }
        }

        boolean[][] after = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            String input = br.readLine();
            int j = 0;
            for (var ch : input.toCharArray()) {
                after[i][j++] = ch == '1';
            }
        }

        int result = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (before[i][j] != after[i][j]) {
                    try {
                        result++;
                        swap(after, i, j, 3);
                    } catch (Exception e) {
                        bw.write("-1");
                        bw.close();
                        br.close();
                        return;
                    }
                }
            }
        }
        bw.write(result + "");
        bw.close();
        br.close();
    }

    static void swap(boolean[][] arr, int r, int c, int d) {
        for (int i = r; i < r + d; i++) {
            for (int j = c; j < c + d; j++) {
                arr[i][j] = !arr[i][j];
            }
        }
    }
}