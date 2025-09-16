import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static Integer[] dp;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        dp = new Integer[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int result = 0;
        for (int i = 0; i < N; i++) {
            result = Math.max(solve(i), result);
        }

        bw.write(Integer.toString(result));

        bw.flush();
        bw.close();
        br.close();
    }

    static int solve(int index) {
        if (dp[index] != null)
            return dp[index];
        int result = 0;
        for (int i = 1; i <= index; i++) {
            if (arr[index - i] < arr[index])
                result = Math.max(solve(index - i), result);
        }
        dp[index] = result + arr[index];
        return dp[index];
    }
}
