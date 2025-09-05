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
        st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        int l = 0, r = max + 1;
        while (l + 1 < r) {
            int mid = (l + r) / 2;
            int cur = 0;
            for (int i = 0; i < n; i++)
                cur += arr[i] / mid;
            if (cur < m)
                r = mid;
            else
                l = mid;
        }
        bw.write(l + "");

        bw.close();
        br.close();
    }
}