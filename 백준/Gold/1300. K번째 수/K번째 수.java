import java.io.*;
import java.util.*;

/**
 * 1 2 3 4 5
 * 1 1 2 3 4 5
 * 2 2 4 6 8 10
 * 3 3 6 9 12 15
 * 4 4 8 12 16 20
 * 5 5 10 15 20 25
 */
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int a = Integer.parseInt(br.readLine());

        int l = 0, r = a;
        while (l < r) {
            int mid = (l + r) / 2;
            int sum = 0;
            for (int dan = 1; dan <= n; dan++) {
                sum += Math.min(mid / dan, n);
            }
            if (sum < a) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        bw.write(l + "");
        bw.close();
        br.close();
    }
}