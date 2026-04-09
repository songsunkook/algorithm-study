import java.io.*;
import java.util.*;

class Main {

    static boolean[][] arr;
    static int[] paper = { 0, 5, 5, 5, 5, 5 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        arr = new boolean[10][10];
        for (int r = 0; r < 10; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < 10; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken()) == 1;
            }
        }

        int result = find(0);

        bw.write(result == 2000000000 ? "-1" : (result + ""));
        bw.close();
        br.close();
    }

    static int find(int cnt) {
        for (int r = 0; r < 10; r++) {
            for (int c = 0; c < 10; c++) {
                if (arr[r][c]) {
                    int min = 2000000000;
                    for (int s = 5; s >= 1; s--) {
                        if (canPut(r, c, s)) {
                            put(r, c, s, true);
                            min = Math.min(min, find(cnt) + 1);
                            put(r, c, s, false);
                        }
                    }
                    return min;
                }
            }
        }
        return 0;
    }

    static boolean canPut(int r, int c, int s) {
        if (!(r >= 0 && r + s <= 10 && c >= 0 && c + s <= 10 && paper[s] > 0)) {
            return false;
        }

        for (int ri = r; ri < r + s; ri++) {
            for (int ci = c; ci < c + s; ci++) {
                if (!arr[ri][ci]) {
                    return false;
                }
            }
        }
        return true;
    }

    static void put(int sr, int sc, int s, boolean flag) {
        if (flag) {
            paper[s]--;
        } else {
            paper[s]++;
        }

        for (int r = sr; r < sr + s; r++) {
            for (int c = sc; c < sc + s; c++) {
                arr[r][c] = !flag;
            }
        }
    }
}