import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long x = Integer.parseInt(st.nextToken());
        long y = Integer.parseInt(st.nextToken());

        long ans = -1;
        long l = 0;
        long r = Integer.MAX_VALUE;
        while (l <= r) {
            long mid = (l + r) / 2;
            if ((long)((y + mid) * 100 / (x + mid)) != (long)(y * 100 / x)) {
                ans = mid;
                r = mid - 1;
            }
            else
                l = mid + 1;
        }
        bw.write(ans + "");
        bw.close();
        br.close();
    }
}