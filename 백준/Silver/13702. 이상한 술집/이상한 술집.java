import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        if (max == 0) {
            bw.write("0");
            bw.close();
            br.close();
            return;
        }

        long l = 1, r = max;
        while (l <= r) {
            long mid = (l + r) / 2;
            if (countOf(arr, mid) >= k) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        bw.write(r + "");

        bw.close();
        br.close();
    }

    static int countOf(int[] arr, long thre) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result += arr[i] / thre;
        }
        return result;
    }
}