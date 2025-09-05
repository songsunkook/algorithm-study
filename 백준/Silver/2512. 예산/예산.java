import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            max = Math.max(max, arr[i]);
        }
        int g = Integer.parseInt(br.readLine());
        if (sum <= g) {
            bw.write(max + "");
            bw.close();
            br.close();
            return;
        }

        int l = 0, r = max + 1;
        while (l + 1 < r) {
            int mid = (l + r) / 2;
            int cur = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] <= mid)
                    cur += arr[i];
                else
                    cur += mid;
            }
            if (cur <= g)
                l = mid;
            else
                r = mid;
        }
        bw.write(l + "");

        bw.close();
        br.close();
    }
}