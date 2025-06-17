import java.io.*;
import java.util.*;

class Main {
    static int n;
    static Integer[] dp;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        dp = new Integer[n];
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int max = 0;
        for (int i = 0; i < n; i++)
            max = Math.max(max, func(i));
        bw.write(max + "");
        bw.close();
        br.close();
    }

    static int func(int a) {
        if (a == -1)
            return 0;
        if (dp[a] != null)
            return dp[a];

        int max = 1;
        for (int i = a - 1; i >= 0; i--) {
            if (arr[i] < arr[a])
                max = Math.max(max, func(i) + 1);
        }
        dp[a] = max;
        return max;
    }
}