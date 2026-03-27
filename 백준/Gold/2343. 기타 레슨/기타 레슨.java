import java.io.*;
import java.util.*;

class Main {

    static int n, m;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }
        int l = max, r = 2000000000;
        while (l < r) {
            int mid = (l + r) / 2;
            int cnt = func(mid);
            if (cnt >= m) {
                l = mid + 1;
            } else {
                r = mid;
            }
            // System.out.printf("(%d, %d): %d\n", l, r, cnt);
        }
        bw.write(l + "");
        bw.close();
        br.close();
    }

    static int func(int len) {
        int sum = 0;
        int cnt = -1;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum == len) {
                sum = 0;
                cnt++;
            }
            if (sum > len) {
                sum = arr[i];
                cnt++;
            }
            // System.out.printf("sum: %d, cnt: %d, len: %d\n", sum, cnt, len);
        }
        if (sum > 0) {
            cnt++;
        }
        // System.out.println("cnt: " + cnt);
        return cnt;
    }
}