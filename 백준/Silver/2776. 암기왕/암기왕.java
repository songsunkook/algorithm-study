import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            Arrays.sort(arr);
            for (int i = 0; i < m; i++){
                int target = Integer.parseInt(st.nextToken());
                bw.write(find(arr, target) ? "1\n" : "0\n");
            }
        }

        bw.close();
        br.close();
    }

    static boolean find(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;
        while (l<r) {
            int mid = (l+r)/2;
            if (arr[mid] < target)
                l = mid + 1;
            else
                r = mid;
        }
        return arr[l] == target;
    }
}