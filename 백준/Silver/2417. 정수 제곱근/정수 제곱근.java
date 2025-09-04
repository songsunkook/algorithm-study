import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(br.readLine());
        long l = 0, r = 10000000000L;
        long mid = 0;
        while (l < r) {
            mid = l / 2 + r / 2;
            double cur = (double)mid * mid;
            if (cur == n) {
                break;
            }
            if (cur < n) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        bw.write((mid * mid < n) ? mid + 1 + "" : mid + "");
        bw.close();
        br.close();
    }
}