import java.io.*;
import java.util.*;

class Main {
    static int count5 = 0;
    static Integer[] dp5 = new Integer[501];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        fac(n);
        bw.write(count5 + "");
        bw.close();
        br.close();
    }

    private static void fac(int n) {
        for (int i = 1; i <= n; i++) {
            if (i % 5 == 0) {
                if (dp5[i / 5] == null)
                    dp5[i / 5] = 0;
                count5 += dp5[i / 5] + 1;
                dp5[i] = dp5[i / 5] + 1;
            }
        }
    }
}