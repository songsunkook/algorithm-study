import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];
        int[] sum = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i - 1] + arr[i];
        }

        int maxIdx = 0;
        int maxVal = 0;
        int maxCount = 0;
        for (int i = x; i <= n; i++) {
            int cur = sum[i] - sum[i - x];
            if (maxVal == cur) {
                maxCount++;
            }
            if (maxVal < cur) {
                maxIdx = i;
                maxVal = cur;
                maxCount = 1;
            }
        }

        if (maxVal == 0)
            bw.write("SAD");
        else
            bw.write(maxVal + "\n" + maxCount);

        bw.close();
        br.close();
    }
}