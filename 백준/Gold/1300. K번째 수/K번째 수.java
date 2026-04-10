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
        int k = Integer.parseInt(br.readLine());

        int l = 0, r = k;
        while (l < r) {
            int mid = (l + r) / 2;
            long cnt = 0;
            // mid(cnt)보다 작은 수의 개수 구하기
            for (int d = 1; d <= n; d++) {
                cnt += Math.min(mid / d, n);
            }

            // mid(cnt)보다 작은 수 개수가 k보다 큼 -> 줄여야 함.
            // mid(cnt)보다 작은 수 개수가 k와 같음 -> 작은 수 개수가 같은 수는 여럿일 수 있다 -> 가장 작은 수를 구해야 한다. ->
            // 줄여야 함.
            if (cnt >= k) {
                r = mid;
            } else {
                // mid(cnt)보다 작은 수 개수가 k보다 작음 -> 키워야 함.
                l = mid + 1;
            }
        }
        bw.write(l + "");

        bw.close();
        br.close();
    }
}