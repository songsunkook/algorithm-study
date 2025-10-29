import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int count = 0;
        for (int k = 0; k < N; k++) {
            int find = arr[k];
            int l = 0, r = N - 1;
            while (l < r) {
                if (arr[l] + arr[r] == find) {
                    if (l != k && r != k) {
                        count++;
                        break;
                    } else {
                        if (l == k) {
                            l++;
                        } else {
                            r--;
                        }
                    }
                } else if (arr[l] + arr[r] > find) {
                    r--;
                } else if (arr[l] + arr[r] < find) {
                    l++;
                }
            }
        }
        bw.write(count + "");
        bw.close();
        br.close();
    }
}