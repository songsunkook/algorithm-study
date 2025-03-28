import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        for (int i = Math.min(a, b); i > 0; i--) {
            if (a % i == 0 && b % i == 0) {
                bw.write(i + "\n");
                break;
            }
        }

        for (int i = Math.max(a, b);; i++) {
            if (i % a == 0 && i % b == 0) {
                bw.write(i + "");
                break;
            }
        }

        bw.close();
        br.close();
    }
}