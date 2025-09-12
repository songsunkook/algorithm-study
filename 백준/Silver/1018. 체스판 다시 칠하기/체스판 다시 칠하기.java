import java.io.*;
import java.util.*;

class Main {

    static int R, C;
    static boolean[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new boolean[R][C]; // W: true / B: false
        for (int r = 0; r < R; r++) {
            String line = br.readLine();
            int c = 0;
            for (char ch : line.toCharArray())
                board[r][c++] = ch == 'W';
        }
        int min = Integer.MAX_VALUE;
        for (int r = 0; r < R - 7; r++) {
            for (int c = 0; c < C - 7; c++) {
                min = Math.min(min, count(r, c, true));
                min = Math.min(min, count(r, c, false));
            }
        }
        bw.write(min + "");
        bw.close();
        br.close();
    }

    static int count(int sr, int sc, boolean first) {
        int result = 0;
        boolean line = first;
        for (int r = sr; r < sr + 8; r++) {
            boolean point = line;
            for (int c = sc; c < sc + 8; c++) {
                if (board[r][c] != point) {
                    result++;
                }
                point = !point;
            }
            line = !line;
        }
        return result;
    }
}