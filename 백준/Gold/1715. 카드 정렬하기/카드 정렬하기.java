import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(a, b));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        long sum = 0;
        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            pq.offer(a + b);
            sum += a + b;
        }
        bw.write(sum + "");
        bw.close();
        br.close();
    }
}