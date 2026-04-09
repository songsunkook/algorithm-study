import java.io.*;
import java.util.*;

class Main {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(arr[i], max);
        }

        long l = max, r = Integer.MAX_VALUE;
        while (l < r) {
            long mid = (l + r) / 2;
            int nowCnt = func((int) mid);
            // 개수가 동일할 때는 사이즈를 줄여야 한다.
            if (nowCnt <= m) {
                // 개수가 더 적다. -> 개수를 늘려야 한다. -> 사이즈를 줄인다.
                r = mid;
            } else {
                // 개수가 더 많다. -> 개수를 줄여야 한다. -> 사이즈를 키운다.
                l = mid + 1;
            }
        }
        bw.write(l + "");
        bw.close();
        br.close();
    }

    static int func(int size) {
        int cnt = 0;
        int sum = 0;
        for (int a : arr) {
            if (a + sum < size) {
                sum += a;
            } else if (a + sum == size) {
                sum = 0;
                cnt++;
            } else {
                sum = a;
                cnt++;
            }
        }
        if (sum > 0) {
            cnt++;
        }
        return cnt;
    }
}