import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int[] source = new int[n+1];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            source[i] = Integer.parseInt(st.nextToken());
        }
        source[n] = 1000000;
        Arrays.sort(source);

        st = new StringTokenizer(br.readLine(), " ");
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int[] target = new int[m];
        for (int i = 0; i < m; i++) {
            target[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < m; i++) {
            int low = 0, high = n;
            while (high - low > 1) {
                if (source[high] == target[i]) {
                    low = high;
                    break;
                }
                int mid = (high + low) / 2;
                if (source[mid] > target[i]) {
                    high = mid;
                } else {
                    low = mid;
                }
            }
            bw.write(Integer.toString(source[low] == target[i] ? 1 : 0) + '\n');
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
