import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        if (n == 1) {
            bw.write("1");
            bw.close();
            br.close();
            return;
        }
        int l = 0, r = 1, sum = 1;
        int result = 0;
        while (l <= n) {
            if (sum == n) {
                result++;
                r++;
                sum += r;
            } else if (sum < n) {
                r++;
                sum += r;
            } else {
                sum -= l;
                l++;
            }
        }
        bw.write(result + "");
        bw.close();
        br.close();
    }
}