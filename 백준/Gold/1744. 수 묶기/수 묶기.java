import java.io.*;
import java.util.*;

/**
 * 절대값이 큰 수끼리 곱해야 한다.
 * 음수를 감안해야 함. 음수는 음수끼리 곱해야 한다.
 * 정렬 이후, 양쪽 끝에서 둘씩 묶어서 더하면 마지막에는 0(중앙)에서 모일 것.
 * 엣지 케이스
 * - 0은 가장 작은 절댓값의 음수와 묶을 수 있지만 양수와 묶으면 안된다.
 * - 1 * 1은 묶지 않아야 한다.
 */
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        if (n == 1) {
            bw.write(arr[0] + "");
            bw.close();
            br.close();
            return;
        }
        Arrays.sort(arr);
        int i = 0;
        long sum = 0;
        while (i + 1 < n && arr[i + 1] <= 0) {
            sum += arr[i] * arr[i + 1];
            i += 2;
        }
        if (i + 1 < n && arr[i + 1] == 0) {
            i += 2;
        }
        if (i < n && arr[i] < 0) {
            sum += arr[i];
        }
        int mid = i;
        i = n - 1;
        while (i - 1 >= mid && arr[i - 1] > 0) {
            if (arr[i] == 1 || arr[i - 1] == 1) {
                sum += arr[i] + arr[i - 1];
                i -= 2;
                continue;
            }
            sum += arr[i] * arr[i - 1];
            i -= 2;
        }
        if (i >= 0 && arr[i] > 0) {
            sum += arr[i];
        }
        bw.write(sum + "");
        bw.close();
        br.close();
    }
}