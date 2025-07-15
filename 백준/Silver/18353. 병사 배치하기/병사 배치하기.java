import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int max = 0;
        int[] len = new int[n];
        int totalMax = 0;
        for (int i = 0; i < n; i++) {
            len[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    len[i] = Math.max(len[i], len[j] + 1);
                }
            }
            totalMax = Math.max(totalMax, len[i]);
        }
        bw.write(n - totalMax + "");
        bw.close();
        br.close();
    }
}