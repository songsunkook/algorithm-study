import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int day = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] a = new int[day + 1];
        int[] b = new int[day + 1];
        a[1] = 1;
        a[2] = 0;
        b[1] = 0;
        b[2] = 1;

        for (int i = 3; i <= day; i++) {
            a[i] = a[i - 1] + a[i - 2];
            b[i] = b[i - 1] + b[i - 2];
        }

        int resultA = 0, resultB = 0;
        for (int na = 1;; na++) {
            int bCount = k - a[day] * na;
            if (bCount < 0)
                break;
            if (bCount % b[day] == 0) {
                int nb = bCount / b[day];
                resultA = na;
                resultB = nb;
                break;
            }
        }

        bw.write(resultA + "\n" + resultB);
        bw.close();
        br.close();
    }
}