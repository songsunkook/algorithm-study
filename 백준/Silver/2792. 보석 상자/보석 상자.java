import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[m];
        int max = 0;
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        int result = 0;
        int l = 1, r = max;
        while (l <= r) {
            int mid = (l + r) / 2;

            int one = 0; // 나눠줄 수 있는 인원 수
            for (int i = 0; i < m; i++) {
                one += (int) Math.ceil((double) arr[i] / mid);
            }

            if (one > n) {
                l = mid + 1;
            } else {
                r = mid - 1;
                result = mid;
            }

        }
        bw.write(result + "");

        bw.close();
        br.close();
    }
}