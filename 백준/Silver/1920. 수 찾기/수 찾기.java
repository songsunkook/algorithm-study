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
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int t = Integer.parseInt(st.nextToken());
            int l = 0, r = n - 1;
            while (l < r) {
                int mid = (l + r) / 2;
                if (arr[mid] == t) {
                    l = mid;
                    break;
                }
                if (arr[mid] < t) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            bw.write(arr[l] == t ? "1\n" : "0\n");
        }

        bw.close();
        br.close();
    }
}