import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0)
                break;
            long max = Long.MIN_VALUE;
            long sum = 0;
            for (int i = 0; i < n; i++) {
                long a = Long.parseLong(br.readLine());
                sum = Math.max(a, sum + a);
                max = Math.max(max, sum);
            }
            bw.write(max + "\n");
        }

        bw.close();
        br.close();
    }
}