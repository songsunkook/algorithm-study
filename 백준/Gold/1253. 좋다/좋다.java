import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        int count = 0;
        for (int i = 0; i < N; i++) {
            int l = 0, r = N - 1;
            while (l < r) {
                int sum = A[l] + A[r];
                if (sum == A[i]) {
                    if (l == i) {
                        l++;
                    } else if (r == i) {
                        r--;
                    } else {
                        count++;
                        break;
                    }
                }
                if (sum < A[i]) {
                    l++;
                }
                if (sum > A[i]) {
                    r--;
                }
            }
        }
        bw.write(count + "");
        bw.close();
        br.close();
    }
}