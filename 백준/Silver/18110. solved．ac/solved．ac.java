import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int deleteCount = (int) Math.round(n * 0.15);
        int realCount = (int) Math.round(n - 2 * deleteCount);

        long result = 0;
        for (int i = deleteCount; i < n - deleteCount; i++) {
            result += arr[i];
        }
        bw.write(Math.round((double)result / realCount) + "");

        bw.close();
        br.close();
    }
}