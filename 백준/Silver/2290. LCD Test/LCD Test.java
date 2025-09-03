import java.io.*;
import java.util.*;

/**
 * -- -- -- -- -- -- -- --
 * | | | | | | | | | | | | | |
 * | | | | | | | | | | | | | |
 * -- -- -- -- -- -- --
 * | | | | | | | | | | | | |
 * | | | | | | | | | | | | |
 * -- -- -- -- -- -- --
 * 
 * 숫자 사이 1칸, 맨앞은 공백 없음
 * s=2: 숫자 1개당 4칸
 * s=3: 숫자 1개당 5칸
 * s=s: 숫자 1개당 s+2칸
 * - 0
 * | | 1 2
 * - 3
 * | | 4 5
 * - 6
 */
class Main {
    static boolean[][] nums = {
            { true, true, true, false, true, true, true }, // 0
            { false, false, true, false, false, true, false }, // 1
            { true, false, true, true, true, false, true }, // 2
            { true, false, true, true, false, true, true }, // 3
            { false, true, true, true, false, true, false }, // 4
            { true, true, false, true, false, true, true }, // 5
            { true, true, false, true, true, true, true }, // 6
            { true, false, true, false, false, true, false }, // 7
            { true, true, true, true, true, true, true }, // 8
            { true, true, true, true, false, true, true } // 9
    };
    static int s, len;
    static String n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        n = st.nextToken();
        len = n.length();
        for (int r = 0; r < 2 * s + 3; r++) {
            for (int c = 0; c < (s + 3) * len; c++) {
                if ((c + 1) % (s + 3) == 0) {
                    bw.write(" ");
                    continue;
                }
                int cur = n.charAt(c / (s + 3)) - '0';
                int idx = getIndexOf(r, c);
                if (idx == -1) {
                    bw.write(" ");
                    continue;
                }
                char output = idx % 3 == 0 ? '-' : '|';
                if (nums[cur][idx]) {
                    bw.write(output);
                } else {
                    bw.write(" ");
                }
            }
            bw.write("\n");
        }

        bw.close();
        br.close();
    }

    static int getIndexOf(int r, int c) {
        int nc = c % (s + 3);
        // 0
        if (r == 0) {
            if (nc == 0 || nc == s + 1)
                return -1;
            return 0;

            // 1 2
        } else if (r < (2 * s + 3) / 2) {
            if (nc != 0 && nc != s + 1)
                return -1;

            if (nc < (s + 2) / 2) {
                return 1;
            } else {
                return 2;
            }

            // 3
        } else if (r == (2 * s + 3) / 2) {
            if (nc == 0 || nc == s + 1)
                return -1;
            return 3;

            // 4 5
        } else if (r < 2 * s + 2) {
            if (nc != 0 && nc != s + 1)
                return -1;

            if (nc < (s + 2) / 2) {
                return 4;
            } else {
                return 5;
            }

            // 6
        } else {
            if (nc == 0 || nc == s + 1)
                return -1;
            return 6;
        }
    }
}