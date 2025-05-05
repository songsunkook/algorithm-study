import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int max = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(arr[i], max);
        }

        int l = 1, r = max;
        int result = 0;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (countOf(arr, mid) >= m) {
                result = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        bw.write(result + "");

        bw.close();
        br.close();
    }

    static int countOf(int[] arr, int splitVal) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result += arr[i] / splitVal;
        }
        return result;
    }
}