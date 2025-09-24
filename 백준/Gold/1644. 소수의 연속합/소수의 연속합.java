import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int idx = 0;
        int[] arr = new int[4000001];
        for (int num = 2; num <= 4000000; num++) {
            if (sosu(num)) {
                arr[idx++] = num;
            }
        }

        int l = 0, r = 0;
        int sum = 0;
        int count = 0;
        while (true) {
            if (sum < n) {
                sum += arr[r++];
            } else if (sum > n) {
                sum -= arr[l++];
            } else {
                count++;
                sum -= arr[l++];
                // bw.write("(" + arr[l] + ", " + arr[r] + "): " + sum + "\n");
                // sum += arr[r++];
            }
            if (arr[r - 1] == 0)
                break;
        }
        bw.write(count + "");

        bw.close();
        br.close();
    }

    static boolean sosu(int n) {
        int sqrt = (int) Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}