import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] line = new int[k];
        for (int i = 0; i < k; i++) {
            line[i] = Integer.parseInt(br.readLine());
        }

        long l = 0, r = (long) Integer.MAX_VALUE + 1;
        while (l + 1 < r) {
            long mid = (l + r) / 2;
            int cnt = 0;
            for (int i = 0; i < k; i++) {
                cnt += line[i] / mid;
            }
            if (cnt >= n) {
                l = mid;
            } else {
                r = mid;
            }
        }
        bw.write(l + "");
        bw.close();
        br.close();
    }
}