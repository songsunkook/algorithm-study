import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int l = 1, r = k;
        while (l < r) {
            int mid = (l + r) / 2;
            int cnt = 0;
            for (int d = 1; d <= n; d++) {
                cnt += Math.min(mid / d, n);
            }
            if (cnt >= k) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        bw.write(l + "");
        bw.close();
        br.close();
    }
}