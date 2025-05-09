import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] arr = new int[m];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int result = Integer.MAX_VALUE;
        int l = 0, r = 100000;
        while (l <= r) {
            int mid = (l + r) / 2;

            boolean can = true;
            for (int i = 1; i < m; i++) {
                if (!(arr[i - 1] + mid >= arr[i] - mid)) {
                    can = false;
                    break;
                }
            }
            if (arr[0] - mid > 0 || arr[m - 1] + mid < n) {
                can = false;
            }

            if (!can) {
                l = mid + 1;
            } else {
                result = Math.min(result, mid);
                r = mid - 1;
            }
        }
        bw.write(result + "");

        bw.close();
        br.close();
    }
}
