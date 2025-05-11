import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr[a - 1] = b;
            }

            int result = 1;
            int minB = arr[0];
            for (int i = 1; i < n; i++) {
                if (minB > arr[i]) {
                    minB = arr[i];
                    result++;
                }
            }

            bw.write(result + "\n");
        }

        bw.close();
        br.close();
    }

    static class P {
        int a;
        int b;

        P(int aa, int bb) {
            a = aa;
            b = bb;
        }
    }
}