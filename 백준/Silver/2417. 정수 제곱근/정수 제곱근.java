import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(br.readLine());
        long l = 0;
        long r = n;
        long mid = r;
        while (l < r) {
            mid = (l + r) / 2;
            double result = Math.pow(mid, 2);
            if (result < n)
                l = mid + 1;
            else
                r = mid;
        }
        bw.write(r + "\n");
        bw.close();
        br.close();
    }
}