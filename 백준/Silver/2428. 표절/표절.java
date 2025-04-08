import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        long sum = 0;
        for (int i = 0; i < n; i++) {
            int now = arr[i];
            sum += i - lower(arr, now, i);
        }
        bw.write(sum + "");

        bw.close();
        br.close();
    }

    static int lower(int[] arr, int target, int max) {
        int l = 0, r = max;
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] <= target && target * 0.9 <= arr[mid])
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
}