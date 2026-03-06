import java.io.*;
import java.util.*;

/**
 * 왼쪽부터 1, 2, ... n자리가 모두 소수여야 한다.
 * -> 각 자리는 모두 소수여야 한다.
 */
class Main {

    static int n;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        dfs(2, 1);
        dfs(3, 1);
        dfs(5, 1);
        dfs(7, 1);

        bw.write(sb + "");
        bw.close();
        br.close();
    }

    static int[] arr = { 1, 3, 5, 7, 9 };

    static void dfs(int num, int digit) {
        if (digit == n) {
            sb.append(num + "\n");
            return;
        }
        for (int a : arr) {
            int next = 10 * num + a;
            if (can(next))
                dfs(next, digit + 1);
        }
    }

    static boolean can(int num) {
        long max = (long) Math.sqrt(num);
        for (int i = 2; i <= max; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}