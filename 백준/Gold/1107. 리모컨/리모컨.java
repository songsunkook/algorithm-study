import java.io.*;
import java.util.*;

class Main {
    static boolean[] btn;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int g = Integer.parseInt(br.readLine());
        String gg = g + "";
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        if (m > 0)
            st = new StringTokenizer(br.readLine());
        btn = new boolean[12];
        Arrays.fill(btn, true);
        for (int i = 0; i < m; i++) {
            int a = Integer.parseInt(st.nextToken());
            btn[a] = false;
        }

        int result = Integer.MAX_VALUE;
        for (int n = 0; n < 500000; n++) {
            for (int d : dd) {
                int cur = g + d * n;
                if (cur < 0 || cur > 10000000)
                    continue;
                char[] curStr = (cur + "").toCharArray();
                boolean can = true;
                for (int i = 0; i < curStr.length; i++) {
                    int ch = curStr[i] - '0';
                    if (!btn[ch]) {
                        can = false;
                        break;
                    }
                }
                if (can) {
                    result = n + curStr.length;
                }
                if (cur == 100) {
                    result = n;
                }
                if (result != Integer.MAX_VALUE) {
                    break;
                }
            }
            if (result != Integer.MAX_VALUE) {
                break;
            }
        }
        result = Math.min(result, Math.abs(g - 100));
        bw.write(result + "");
        bw.close();
        br.close();
    }

    static int[] dd = { -1, 1 };
}