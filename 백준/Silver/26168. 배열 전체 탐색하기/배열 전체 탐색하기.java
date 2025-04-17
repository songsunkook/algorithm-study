import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[] arr = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            switch (a) {
                case 1:
                    bw.write(n - lowerIdx(arr, b) + "\n");
                    break;
                case 2:
                    bw.write(n - upperIdx(arr, b) + "\n");
                    break;
                case 3:
                    long c = Long.parseLong(st.nextToken());
                    bw.write(upperIdx(arr, c) - lowerIdx(arr, b) + "\n");
                    break;
            }
        }

        bw.close();
        br.close();
    }

    static int upperIdx(long[] arr, long target) {
        int l = 0, r = arr.length;
        while(l < r) {
            int mid = (l+r)/2;
            if (arr[mid] <= target)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }

    static int lowerIdx(long[] arr, long target) {
        int l = 0, r = arr.length;
        while(l < r) {
            int mid = (l+r)/2;
            if (arr[mid] < target)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }
}