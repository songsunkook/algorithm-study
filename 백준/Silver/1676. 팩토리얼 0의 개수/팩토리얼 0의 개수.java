import java.io.*;
import java.util.*;

class Main {
    static int count2 = 0;
    static int count5 = 0;
    static Integer[] dp2 = new Integer[501];
    static Integer[] dp5 = new Integer[501];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        fac(n);
        bw.write(Math.min(count2, count5) + "");
        bw.close();
        br.close();
    }

    private static void fac(int n) {
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                if (dp2[i / 2] == null)
                    dp2[i / 2] = 0;
                count2 += dp2[i / 2] + 1;
                dp2[i] = dp2[i / 2] + 1;
            }
            if (i % 5 == 0) {
                if (dp5[i / 5] == null)
                    dp5[i / 5] = 0;
                count5 += dp5[i / 5] + 1;
                dp5[i] = dp5[i / 5] + 1;
            }
        }
    }
}