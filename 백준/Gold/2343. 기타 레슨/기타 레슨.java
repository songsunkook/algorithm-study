import java.io.*;
import java.util.*;

/**
 * 동일한 길이의 블루레이 m개에 모든 강의를 담는다.
 * 블루레이 길이를 최소화해야 한다.
 * 블루레이 m개에 모든 강의를 담을 수 있는 가장 작은 블루레이 길이는?
 * 
 * 임의의 큰 블루레이 길이를 정하고, 이걸 r로 두고 이분탐색한다.
 * 각 이분탐색 루프에서는 이 길이로 나눌 때 총 몇개의 블루레이가 나오는지 확인한다.
 * m개보다 많이 나오면 길이를 키우고(l = mid)
 * m개보다 적게 나오면 길이를 줄인다(r = mid)
 */
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        int max = 0, total = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
            total += arr[i];
        }

        int l = max, r = total;
        while (l < r) {
            int mid = (l + r) / 2;

            int sum = 0, cnt = 1;
            for (int i = 0; i < n; i++) {
                if (sum + arr[i] > mid) {
                    cnt++;
                    sum = 0;
                }
                sum += arr[i];
            }

            if (cnt <= m) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        bw.write(l + "");
        bw.close();
        br.close();
    }
}