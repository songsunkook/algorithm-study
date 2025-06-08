import java.io.*;
import java.util.*;

class Main {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> {
            if (Math.abs(a) == Math.abs(b))
                return Integer.compare(a, b);
            return Integer.compare(Math.abs(a), Math.abs(b));
        });
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x != 0) {
                q.offer(x);
            } else {
                if (q.isEmpty())
                    bw.write("0\n");
                else
                    bw.write(q.poll() + "\n");
            }
        }

        bw.close();
        br.close();
    }
}