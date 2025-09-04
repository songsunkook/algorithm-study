import java.io.*;
import java.util.*;

class Main {

    static int k, n;
    static int[] lines;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        long maxL = 0;
        lines = new int[k];
        for (int i = 0; i < k; i++) {
            int a = Integer.parseInt(br.readLine());
            maxL = Math.max(maxL, a);
            lines[i] = a;
        }
        long l = 0, r = maxL + 1;
        while (l + 1 < r) {
            long mid = (l + r) / 2;
            int cnt = cut(mid);
            if (n <= cnt) {
                l = mid;
            } else {
                r = mid;
            }
        }
        bw.write(l + "");
        bw.close();
        br.close();
    }

    static int cut(long len) {
        int count = 0;
        for (int i = 0; i < k; i++) {
            int remain = lines[i];
            while (true) {
                if (remain < len)
                    break;
                remain -= len;
                count++;
            }
        }
        return count;
    }
}